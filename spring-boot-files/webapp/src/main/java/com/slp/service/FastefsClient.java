package com.slp.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sangliping on 2017/9/4.
 */
@Service
public class FastefsClient {

    @Autowired
    protected FastFileStorageClient storageClient;

    /**
     * 上传文件
     * @param file
     * @return
     */

    public String uploadFile(MultipartFile file){
        String fileType = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        StorePath path = null;
        try {
            path = storageClient.uploadFile(file.getInputStream(),file.getSize(),fileType,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(path != null){
            return path.getFullPath();
        }else {
            return null;
        }
    }

    /**
     * 上传文件
     * @param inputStream
     * @param size
     * @param type
     * @return
     */
    public String uploadFile(InputStream inputStream,Long size,String type){
        StorePath path = null;
        try {
        path = storageClient.uploadFile(inputStream,size,type,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(path!=null){
            return path.getFullPath();
        }else {
            return  null;
        }
    }

    /**
     * 删除文件
     * @param fullPath
     */

    public void deleteFile(String fullPath){
        storageClient.deleteFile(fullPath);
    }
}
