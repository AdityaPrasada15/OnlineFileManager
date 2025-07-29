package com.prasadaa.OnlineFileManager.controller;

import com.prasadaa.OnlineFileManager.service.FileSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class FileManagerController {

    @Autowired
    FileSaveService fileSaveService;
    //logger
    private static final Logger log = Logger.getLogger(FileManagerController.class.getName());

    @PostMapping("/uploadFile")
    public boolean uploadFile(@RequestParam("file")MultipartFile file){
        try {
            fileSaveService.saveFile(file);
            return true;
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception during the upload.", e);
        }
        return false;
    }
}
