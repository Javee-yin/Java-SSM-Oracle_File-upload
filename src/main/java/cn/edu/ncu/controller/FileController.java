package cn.edu.ncu.controller;


import cn.edu.ncu.pojo.Img;
import cn.edu.ncu.service.IimgService;
import com.alibaba.druid.support.http.util.IPAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @Author Javee
 * @Date 2020/5/18 17:31
 * @Description
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IimgService imgService;

    @PostMapping("/upload.action")
    public ModelAndView upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        //将上传的文件存入本地
        String fileUniqueName = UUID.randomUUID().toString().replaceAll("-","");
        fileUniqueName += fileName.substring(fileName.lastIndexOf("."));
        File fileNew = new File("f:" + File.separator + "imgFile" + File.separator + fileUniqueName);
        fileNew.createNewFile();
        file.transferTo(fileNew);

//        String str = URLEncoder.encode(file.getOriginalFilename(), "utf-8");

        // 获取本地ip
        InetAddress ia = null;
        ia = ia.getLocalHost();
        String localAddress = ia.getHostAddress();
        String str = "http://" + localAddress + ":8080/file/image.action?imgPath=" + fileUniqueName;

        ModelAndView modelAndView = new ModelAndView("redirect:/page/success.html?address=" + str);

        Img img = new Img();
        img.setImgPath(fileUniqueName);

        imgService.save(img);

        return modelAndView;
    }


    @RequestMapping("/image.action")
    public void getImage(String imgPath, HttpServletResponse response) {
        File file = new File("f:/imgFile/" + imgPath);
        if(!file.exists()) return;
        byte[] data = new byte[1024 * 1024];
        try(InputStream is = new FileInputStream(file);
            ServletOutputStream os = response.getOutputStream();) {
            // 告诉浏览器准备下载,并赋予下载文件的名字
            response.setHeader("Content-Disposition", "attachment;");
            // 告诉浏览器, 我不是响应页面, 而是响应一个二进制数据(流)
            response.setContentType("application/octet-stream");
            int len = 0;
            while((len = is.read(data)) != -1) {
                os.write(data, 0, len);
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
