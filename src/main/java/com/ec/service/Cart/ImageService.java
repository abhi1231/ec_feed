package com.ec.service.cart;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {
    private static final String UPLOAD_DIR = "/path/to/upload/directory";

    public String saveImage(MultipartFile imageFile) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + imageFile.getOriginalFilename();
        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();
        File destFile = new File(filePath);
        imageFile.transferTo(destFile);
        return fileName;
    }
}
