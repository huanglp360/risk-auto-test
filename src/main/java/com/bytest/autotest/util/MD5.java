package com.bytest.autotest.util;

import java.security.MessageDigest;

public class MD5 {
    private static final String DEFAULT_CHARSET = "utf-8";
    private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public static String digest(String data) {
        String result = null;
        if ((data != null) && (data.length() > 0)) {
            try
            {
                byte[] bytes = MessageDigest.getInstance("MD5").digest(
                        data.getBytes("utf-8"));
                result = byteToString(bytes);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }


    private static String byteToString(byte[] bByte)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sb.append(byteToArrayString(bByte[i]));
        }
        return sb.toString();
    }

    private static String byteToArrayString(byte bByte)
    {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return hexDigits[iD1] + hexDigits[iD2];
    }
}
