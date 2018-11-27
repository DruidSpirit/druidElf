package c3p0Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class c3p0Test {
    public static void main(String[] args) {
       String sql = "select id,link_txt,has_loaddown,repository_path from druid_novel_resource limit 10";
        List<Map<String, Object>> list = dataDeal.getC3p0list(sql);
        System.out.println(list.size());
    }
}
