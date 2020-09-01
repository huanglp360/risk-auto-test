package com.bytest.autotest.util;


import com.bytest.autotest.domain.BreEventParam;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Data2xlsx {
    public static void write(String filepath,List<BreEventParam> list){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = null;
        String[] title = {"EVENT_ID","变量名称","变量值","变量类型","节点","节点名称","创建日期","创建时间"};
        for (int i = 0; i <title.length ; i++) {
            cell=row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //写入数据
        for (int i = 1; i <list.size() ; i++) {
            XSSFRow nrow = sheet.createRow(i);
            XSSFCell ncell=nrow.createCell(0);
            ncell.setCellValue(list.get(i).getEventId());
            ncell = nrow.createCell(1);
            ncell.setCellValue(list.get(i).getParamCode());
            ncell = nrow.createCell(2);
            ncell.setCellValue(list.get(i).getParamValue());
            ncell = nrow.createCell(3);
            ncell.setCellValue(list.get(i).getParamType());
            ncell= nrow.createCell(4);
            ncell.setCellValue(list.get(i).getParentNode());
            ncell = nrow.createCell(5);
            ncell.setCellValue(list.get(i).getNodeName());
            ncell=nrow.createCell(6);
            ncell.setCellValue(list.get(i).getCreateDate());
            ncell=nrow.createCell(7);
            ncell.setCellValue(list.get(i).getCreateTime());
        }
        File file = new File(filepath+".xlsx");
        try {
            if(file.isDirectory()){

            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void writeMaps(String path, Map<String,Object> map){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = null;
        String[] title = {"变量名称","变量值"};
        for (int i = 0; i <title.length ; i++) {
            cell=row.createCell(i);
            cell.setCellValue(title[i]);
        }
        int count = 0;
        for (Map.Entry<String,Object> enttry:map.entrySet()) {
            XSSFRow nrow = sheet.createRow(count);
            XSSFCell ncell = nrow.createCell(0);
            ncell.setCellValue(enttry.getKey());
            ncell = nrow.createCell(1);
            ncell.setCellValue(String.valueOf(enttry.getValue()));
            count++;
        }
        File file = new File(path+".xlsx");
        try {
            if(file.isDirectory()){

            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
