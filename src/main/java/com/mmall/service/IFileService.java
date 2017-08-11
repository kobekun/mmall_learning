package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dell on 2017/7/28.
 */
public interface IFileService {
    String  upload(MultipartFile file, String path);
}
