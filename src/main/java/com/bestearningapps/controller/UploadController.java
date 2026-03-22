package com.bestearningapps.controller;

import com.bestearningapps.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/upload")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://best-earning-apps.netlify.app"
})
public class UploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        String fileName = fileStorageService.saveFile(file);

        return fileName;
    }
}