package com.example.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${app.img.location}")
    String imagesLocation;

    @Override
    public String storeInFileSystem(MultipartFile file) {

        if(file == null
                || !StringUtils.hasLength(file.getOriginalFilename())
                || StringUtils.getFilenameExtension(file.getOriginalFilename()) == null)
            throw new IllegalArgumentException("Wrong image");

        String fileNameWithExtension = file.getOriginalFilename(); // logo_impresionante.jpg
        String extension = StringUtils.getFilenameExtension(fileNameWithExtension); // jpg
        String fileName = fileNameWithExtension.replace("." + extension, ""); // logo_impresionante
        String fileNameToSave = fileName + "_" + System.currentTimeMillis() + "." + extension; // logo_impresionante_423423873845.jpg

        try {
            Path path = Paths.get(imagesLocation).resolve(fileNameToSave);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Failed to save image");
        }
        return fileNameToSave;
    }
}