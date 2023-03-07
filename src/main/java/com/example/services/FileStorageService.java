package com.example.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String storeInFileSystem(MultipartFile file);
}
