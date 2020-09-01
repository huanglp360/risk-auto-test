package com.bytest.autotest.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hlp on 2020/3/19.
 * 数据获取
 */
public class DataUtils {

    private static Object[][] obj;
    private static List sonList = new ArrayList();

    public static Object[][] getTestData(String target, String key) {

        String casePath = System.getProperty("user.dir") + target;
        String caseData = txt2String(casePath);
        sonList = readJson2StrList(caseData, key);
        obj = new Object[readJson2StrList(caseData, key).size()][];
        for (int i = 0; i < readJson2StrList(caseData, key).size(); i++) {
            obj[i] = new Object[]{sonList.get(i)};
        }
        return obj;
    }

    /**
     * 解析json文件为String字符串
     *
     * @param path
     * @return json文件所有内容
     */
    public static String txt2String(String path) {
        StringBuilder result = new StringBuilder();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                result.append("\n").append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String readJson(String testJson, String key) {
        JSONObject jsonObject = JSON.parseObject(testJson);
        String caseData = jsonObject.getJSONObject(key).toString();

        return caseData;
    }
    public static String readJson(String testJson) {
        JSONObject jsonObject = JSON.parseObject(testJson);
        String caseData = jsonObject.toString();

        return caseData;
    }

    /**
     * 根据key在jsonStr中找到对应的字符串并且转换成ArryaList<String>
     *
     * @param jsonStr
     * @param key
     * @return
     */
    public static ArrayList<String> readJson2StrList(String jsonStr, String key) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        ArrayList<String> arrayList = new ArrayList<String>();

        Object listArray = new JSONTokener(jsonObject.getString(key)).nextValue();

        if (listArray instanceof org.json.JSONArray) {
            JSONArray array = jsonObject.getJSONArray(key);
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getString(i));
            }
        } else {
            arrayList.add(jsonObject.getJSONObject(key).toString());
        }
        return arrayList;
    }


    public static ArrayList<Integer> readJson2IntList(String jsonStr, String key) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        Object listArray = new JSONTokener(jsonObject.getString(key)).nextValue();

        if (listArray instanceof JSONArray) {
            JSONArray array = jsonObject.getJSONArray(key);
            for (int i = 0; i < array.size(); i++) {
                arrayList.add(array.getIntValue(i));
            }
        } else {
            arrayList.add(Integer.parseInt(jsonObject.getJSONObject(key).toString()));
        }
        return arrayList;
    }
    public static String getRandomNum(){
        String num1;
        String num2;
        while (true){
            num1 =String.valueOf((int)(Math.random()*10000));
            num2 =String.valueOf((int)(Math.random()*10000));
            if((num1+num2).length()==8){
                break;
            }
        }
        return num1+num2;
    }

}


