package com.bytest.autotest.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class KeyUtil {

    /**
     * Created by hlp on 2020/3/19.
     * 加密
     */
    public static String encryptAES(String plainTextData, String key)throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] encryptedData = cipher.doFinal(plainTextData.getBytes("UTF-8"));
        return Base64.encodeBase64String(encryptedData);
    }

    /**
     * Created by hlp on 2020/3/19.
     * 解密
     */
    public static String decryptAES(String encryptedData, String key)throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, new SecretKeySpec(key.getBytes(), "AES"));
        byte[] decryptedData = cipher.doFinal(Base64.decodeBase64(encryptedData));

        return new String(decryptedData, "UTF-8");
    }


}
