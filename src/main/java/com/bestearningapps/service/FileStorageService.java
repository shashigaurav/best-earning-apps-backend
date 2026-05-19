package com.bestearningapps.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    // Render/Linux server friendly path
    private final String uploadDir =
            System.getProperty("java.io.tmpdir") + "/uploads/";

    public String saveFile(MultipartFile file) throws IOException {

        // Create uploads folder if not exists
        File folder = new File(uploadDir);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Generate unique file name
        String fileName =
                System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Save file
        File destination = new File(folder, fileName);

        file.transferTo(destination);

        return fileName;
    }
}