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

        // Create uploads folder if not exists
        File folder = new File(uploadDir);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Generate unique filename
        String fileName =
                System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Destination file
        File destination =
                new File(folder, fileName);

        // Save file
        file.transferTo(destination);

        // Return public image path
        return "/uploads/" + fileName;
    }
}