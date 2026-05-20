package com.bestearningapps.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    // Render/Linux compatible upload path
    private final String uploadDir =
            System.getProperty("java.io.tmpdir") + "/uploads/";

    public String saveFile(MultipartFile file) throws IOException {

        // create uploads folder if not exists
        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        // unique file name
        String fileName =
                System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // final destination
        File destination = new File(uploadDir + fileName);

        // save file
        file.transferTo(destination);

        // return path for DB
        return "uploads/" + fileName;
    }
}