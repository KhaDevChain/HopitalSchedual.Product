package com.az9s.hopital.Backend.utils.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public String writeFile(String dir, String fileName, byte[] fileData) throws IOException {
        // Tạo thư mục nếu chưa tồn tại
        File directory = new File(dir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Đường dẫn file
        Path filePath = Paths.get(dir, fileName);

        // Lưu file
        Files.write(filePath, fileData);

        // Trả về đường dẫn tương đối của file
        return filePath.toString();
    }


    public byte[] readFile(String dir, String fileName) throws IOException {
        // Đường dẫn file
        Path filePath = Paths.get(dir, fileName);

        // Kiểm tra file có tồn tại
        if (!Files.exists(filePath)) {
            throw new IOException("File not found: " + fileName);
        }

        // Đọc và trả về nội dung file
        return Files.readAllBytes(filePath);
    }
}
