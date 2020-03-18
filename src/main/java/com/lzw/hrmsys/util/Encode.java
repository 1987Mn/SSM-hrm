package com.lzw.hrmsys.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Encode {

    public static String encodByMD5(String password){
        //加密方式
        String hashAlgorithmName = "MD5";
        //密码原值
        Object crdentials = password;
        //盐值
        Object salt = null;
        //加密1次
        int hashIterations = 1;
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        return result.toString();
    }
}
