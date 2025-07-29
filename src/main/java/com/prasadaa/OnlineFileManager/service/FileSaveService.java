package com.prasadaa.OnlineFileManager.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileSaveService {

    private static final String PATH = "C:\\Study Materials";

    public void saveFile(MultipartFile file) throws IOException {
        //null check
        if (file == null){
            throw new NullPointerException("File not found.");
        }
        var targetFIle = new File(PATH + File.separator + file.getOriginalFilename());
        //security handling
        if(!Objects.equals(targetFIle.getParent(), PATH)){
            throw new SecurityException("Invalid/ Unsupported File.");
        }
        Files.copy(file.getInputStream(), targetFIle.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
