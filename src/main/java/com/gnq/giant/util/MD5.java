package com.gnq.giant.util;


import org.springframework.util.DigestUtils;

/**
 * Created by NightGuo on 2019/3/19.
 *
 * @Author: NightGuo
 * @Description:
 * @Date: 15:48 2019/3/19
 */
public class MD5 {
    /**
     * MD5方法
     *
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String key) {
        try{
            //加密后的字符串
            String encodeStr= DigestUtils.md5DigestAsHex(key.getBytes());
            System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
            return encodeStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * MD5验证方法
     *
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }
}
