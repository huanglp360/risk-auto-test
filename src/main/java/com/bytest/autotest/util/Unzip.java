package com.bytest.autotest.util;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * <h3>tool</h3>
 * <p>解压缩</p>
 *
 * @author : hh
 * @date : 2020-04-14 09:44
 **/
public class Unzip {
    public static Map unzipFiles(String zippath,String target) throws IOException {
        return unzipFiles(new ZipFile(zippath),target);
    }

    public static Map unzipFiles(ZipFile zipFile,String target) throws IOException {
        File file = new File(target);
        if(!file.exists()){
            file.mkdirs();
        }
        Map<String,String> map = new HashMap<>();

        for (Enumeration enumeration = zipFile.entries();enumeration.hasMoreElements();){
            ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
            InputStream inputStream  = zipFile.getInputStream(zipEntry);
            String FileNanme = zipEntry.getName();
            String outfilepath = (target+FileNanme).replace("\\*",File.separator);

            map.put(FileNanme,outfilepath);

            File path = new File(outfilepath.substring(0,outfilepath.lastIndexOf("/")));

            if(!path.exists())
            {
                path.mkdirs();
            }

            if(new File(outfilepath).isDirectory()){
                continue;
            }

            OutputStream outputStream = new FileOutputStream(outfilepath);
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf))>0){
                outputStream.write(buf,0,len);
            }
            inputStream.close();
            outputStream.close();
        }
        return map;
    }

}
