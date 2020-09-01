package com.bytest.autotest.controller;

import com.bytest.autotest.config.ServerConfig;
import com.bytest.autotest.domain.UserInfo;
import com.bytest.autotest.innerService.UserInfoService;
import com.bytest.autotest.util.DataUtils;
import com.bytest.autotest.util.Ocr;
import com.bytest.autotest.util.PageResult;
import com.bytest.autotest.util.Unzip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * <h3>risk-auto-test</h3>
 * <p>测试数据</p>
 *
 * @author : hh
 * @date : 2020-05-03 15:04
 **/
@Slf4j
@Controller
public class TestDataController {

    @Value("${uploadpath}")
    private String imagepath;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ServerConfig serverConfig;

    @RequestMapping("testdata")
    public String testdata() {
        return "/testdata";
    }


    @PostMapping("uploadzip")
    @ResponseBody
    public void uploadzip(@RequestParam(value = "file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            log.info("文件为空");
        }
        String flag = DataUtils.getRandomNum();
        String filename = file.getOriginalFilename();
        log.info("获取打的文件名" + filename);
        File realfile = new File(imagepath);
        String filepath = realfile.getAbsolutePath() + File.separator + flag + filename;
        log.info("获取打的文件名和路径" + filepath);
        File dest = new File(filepath);
        log.info("获取到的最终文件地址为：" + dest.getPath());
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!filename.substring(filename.length() - 3, filename.length()).equals("zip")) {
            UserInfo userInfoimg = Ocr.read(filepath, "front");
            flag = DataUtils.getRandomNum();
            userInfoimg.setIsused("0");
            userInfoimg.setMobile("150" + flag);
            userInfoimg.setBankcard("62170000101" + flag);
            userInfoimg.setFrontpath(serverConfig.getUrl() + "pic/" + dest.getName());
            userInfoimg.setCreatedatetime(new Date());
            userInfoService.inSert(userInfoimg);
        } else {
            Map<String, String> map = Unzip.unzipFiles(filepath, imagepath);
            dest.delete();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String fileEntyPath = entry.getValue();
                UserInfo userInfo = Ocr.read(fileEntyPath, "front");
                flag = DataUtils.getRandomNum();
                userInfo.setIsused("0");
                userInfo.setMobile("150" + flag);
                userInfo.setBankcard("62170000101" + flag);
                File filetemp = new File(fileEntyPath);
                String temp = filetemp.getName();
                String temp_name = temp.substring(0,temp.indexOf("."))+"_"+userInfo.getId_No()+temp.substring(temp.length()-4,temp.length());
                File dest2 = new File(filetemp.getParent()+File.separator+temp_name);
                filetemp.renameTo(dest2);
                userInfo.setFrontpath(serverConfig.getUrl() + "pic/" + dest2.getName());
                userInfo.setCreatedatetime(new Date());
                userInfoService.inSert(userInfo);
            }

        }

    }


    @PostMapping("list")
    @ResponseBody
    public PageResult getdata(@RequestParam(value = "page", defaultValue = "1") String page,
                              @RequestParam(value = "rows", defaultValue = "10") String size) {
        PageResult pageResult = userInfoService.getPageResult(Integer.parseInt(page), Integer.parseInt(size));
        log.info("返回的数据：{}", pageResult);
        return pageResult;

    }

}
