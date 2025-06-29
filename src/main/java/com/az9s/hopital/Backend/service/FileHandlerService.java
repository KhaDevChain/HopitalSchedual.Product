package com.az9s.hopital.Backend.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileHandlerService {
    String storeFile(MultipartFile file, String moduleFolder) throws IOException;
    byte[] readFile(String dir, String fileName) throws IOException;
    String writeFile(String dir, String fileName, byte[] fileData) throws IOException;
}
