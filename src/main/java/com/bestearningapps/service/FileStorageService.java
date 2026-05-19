package com.bestearningapps.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private final String uploadDir = "uploads/";

    public String saveFile(MultipartFile file) throws IOException {

        // Create uploads folder if not exists
        File folder = new File(uploadDir);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Generate file name
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Save file
        File destination = new File(folder, fileName);

        file.transferTo(destination);

        return fileName;
    }
}