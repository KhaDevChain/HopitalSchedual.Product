package com.az9s.hopital.Backend.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.az9s.hopital.Backend.service.FileHandlerService;
import com.az9s.hopital.Backend.utils.handler.FileHandler;

@Service
public class FileHandlerServiceImpl implements FileHandlerService {
    private final String BASE_PATH = "src/main/resources/static/assets";

    @Override
    public String storeFile(MultipartFile file, String moduleFolder) throws IOException {
        if (file == null || file.isEmpty()) throw new IOException("Tệp rỗng hoặc không hợp lệ");
        FileHandler fileHandler = new FileHandler();
        return fileHandler.storeFile(file, moduleFolder, BASE_PATH);
    }

    @Override
    public byte[] readFile(String dir, String fileName) throws IOException {
        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(dir, fileName);
    }

    @Override
    public String writeFile(String dir, String fileName, byte[] fileData) throws IOException {
        if (fileData == null || fileData.length == 0) {
            throw new IOException("Dữ liệu file trống");
        }
        FileHandler fileHandler = new FileHandler();
        return fileHandler.writeFile(dir, fileName, fileData);
    }
}
