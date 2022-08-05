package com.universe.demo.springboot.filedemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
    @ResponseBody
    @RequestMapping("filesUpload")
    public String filesUpload(@RequestParam("id") String id,@RequestParam("files") MultipartFile[] files) {
        //判断file数组不能为空并且长度大于0
        if(files!=null&&files.length>0){
            //循环获取file数组中得文件
            for(int i = 0;i<files.length;i++){
                MultipartFile file = files[i];
                //保存文件
                ///saveFile(file);
            }
        }
        // 重定向
        return "ok";
    }

    @ResponseBody
    @RequestMapping("filesUpload2")
    public String filesUpload2(MultipartHttpServletRequest request) {

        // 重定向
        return "ok";
    }
}
