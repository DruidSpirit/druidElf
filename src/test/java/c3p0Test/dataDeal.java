package c3p0Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataDeal {
    public static List<Map<String, Object>> getC3p0list (String sql) {
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        try {
            long beginTime = System.currentTimeMillis();
            Connection con = DbUtil.getConnection();
            // 执行查询语句
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (rs.next()) {
                Map<String,Object> rowData = new HashMap<String,Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
