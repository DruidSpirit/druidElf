package com.druid.util;

import com.druid.entity.DruidUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroMd5Util {
    //添加user的密码加密方法
    public static DruidUser  SysMd5(DruidUser druidUser) {

        if (druidUser == null) return null;

        if (druidUser.getSalt() == null) druidUser.setSalt(createRandom(false, 8));

        String hashAlgorithmName = "MD5";//加密方式

        Object crdentials =druidUser.getPassword();//密码原值

        ByteSource salt = ByteSource.Util.bytes(druidUser.getSalt());//以账号作为盐值

        int hashIterations = 1024;//加密1024次

        SimpleHash hash = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);

        druidUser.setPassword(hash.toString());

        return druidUser;
    }

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag
     *            是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890"
                : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }
}
