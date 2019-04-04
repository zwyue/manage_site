package com.zr.gansu.manage.controller;

import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.manage.configs.UploadSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @description: 文件上传Controller
 * @author: KaiZhang
 * @create: 2019-01-09 15:42
 **/
@Controller
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    private final
    UploadSettings uploadSettings;

    @Autowired
    public UploadController(UploadSettings uploadSettings) {
        this.uploadSettings = uploadSettings;
    }


    @RequestMapping("/page")
    public String testPage(){
        return "test";
    }

    /**
     * 多图片上传
     * @param list 多图片地址
     * @return 返回地址
     */
    @ResponseBody
    @RequestMapping(value = "/multi/img",method = RequestMethod.POST)
    public Map multiImgUpload(@RequestParam("myfile") List<MultipartFile> list) {
        //获取视频文件存储路径 如:videos/video
        String imgStoragePath = uploadSettings.getImgStoragePath();
        LinkedList<String> imgUrlList = new LinkedList<>();
        for (MultipartFile file : list) {
            //存储文件,生成文件下载地址 如:http://39.98.83.113:81/videos/micro/abc.mp4
            String imgLink = createLink(file,imgStoragePath);
            imgUrlList.add(imgLink);
        }
        return ResultUtils.success(imgUrlList);
    }

    /**
     * wangEditor图片上传
     * @param list 多图片地址
     * @return 返回地址
     */
    @ResponseBody
    @RequestMapping(value = "/editor/img",method = RequestMethod.POST)
    public Map EditorImgUpload(@RequestParam("myfile") List<MultipartFile> list) {
        //获取视频文件存储路径 如:videos/video
        String imgStoragePath = uploadSettings.getImgStoragePath();
        LinkedList<String> imgUrlList = new LinkedList<>();
        for (MultipartFile file : list) {
            //存储文件,生成文件下载地址 如:http://39.98.83.113:81/videos/micro/abc.mp4
            String imgLink = createLink(file,imgStoragePath);
            imgUrlList.add(imgLink);
        }
        return ResultUtils.errno(imgUrlList);
    }


    /**
     * 单图片上传
     * @param file 图片文件
     * @return ResultUtils 图片资源地址
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public Map singleImgUpload(@RequestParam("file") MultipartFile file) {
        //获取图片文件存储路径
        String imgStoragePath = uploadSettings.getImgStoragePath();
        //存储文件,生成文件下载地址 如:http://39.98.83.113:81/videos/micro/abc.mp4
        String imgLink = createLink(file,imgStoragePath);
        return ResultUtils.success(imgLink);
    }


    /**
     * 通用,普通 单视频上传
     * @param file 视频文件
     * @return ResultUtils 视频资源地址
     */
    @ResponseBody
    @RequestMapping(value = "/resources/video",method = RequestMethod.POST)
    public Map singleVideoUpload(@RequestParam("file") MultipartFile file) {
        //获取视频文件存储路径 如:videos/video
        String commonVideoStoragePath = uploadSettings.getResourcesVideoStoragePath();
        //存储文件,生成文件下载地址 如:http://39.98.83.113:81/videos/micro/abc.mp4
        String videoLink = createLink(file,commonVideoStoragePath);
        return ResultUtils.success(videoLink);
    }

    /**
     * 课程视频模块:视频上传
     * @param file 视频文件
     * @return ResultUtils 视频资源地址
     */
    @ResponseBody
    @RequestMapping(value = "/course/video",method = RequestMethod.POST)
    public Map moduleVideoModuleUpload(@RequestParam("file") MultipartFile file) {
        //获取视频文件存储路径 如:videos/video
        String videoStoragePath = uploadSettings.getCourseVideoStoragePath();
        //存储文件,生成文件下载地址 如:http://39.98.83.113:81/videos/micro/abc.mp4
        String videoLink = createLink(file,videoStoragePath);
        return ResultUtils.success(videoLink);
    }


    /**
     * 将文件存入指定文件夹中生成的文件夹内,返回文件的下载地址
     * @param file 接收的MultipartFile 文件对象
     * @param typeStoragePath 文件类型路径(决定存储及返回路径)
     * @return 下载地址
     */
    private String createLink(MultipartFile file,String typeStoragePath){
        //获取文件存储基础目录 如:/usr/local/resources
        String baseStoragePath = uploadSettings.getBaseStoragePath();
        //获取文件仓库访问地址 如: http://39.98.83.113:81
        String repoPath = uploadSettings.getRepoPath();
        //文件存储路径 如:/usr/local/resources/videos/video
        String storagePath = baseStoragePath+"/"+typeStoragePath;
        //生成日期文件夹字符串 如: 2019/1/18/1546582147748
        String dateDir = getDateDir();
        String originFileName = file.getOriginalFilename();
        String generatedDir = dateDir+"/"+originFileName;
        String fileStorageDir = storagePath+"/"+generatedDir;
        createDirectory(storagePath+"/"+dateDir);
        File fileStorage = new File(fileStorageDir);
        fileTransfer(file,fileStorage);
        return repoPath+"/"+typeStoragePath+"/"+generatedDir;
    }

    /**
     * 生成当前日期文件目录的字符串  如 2019/1/18/1546582147748
     * @return 2019/1/18/1546582147748
     */
    private String getDateDir(){
        Calendar now = Calendar.getInstance();
        String date = now.get(Calendar.YEAR) + "" + (now.get(Calendar.MONTH) + 1) + "" + now.get(Calendar.DAY_OF_MONTH);
        String nowTime = System.currentTimeMillis() + "";
        return date + "/" + nowTime;
    }



    /**
     * 文件转换，MultipartFile 转为文件
     * @param file MultipartFile
     * @param filePath filePath
     */
    private void fileTransfer(MultipartFile file,File filePath){
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件夹
     * @param folder 文件夹
     */
    private static void createDirectory(String folder) {
        File dir = new File(folder);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}

