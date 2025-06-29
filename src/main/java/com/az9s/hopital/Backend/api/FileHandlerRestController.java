package com.az9s.hopital.Backend.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.az9s.hopital.Backend.service.FileHandlerService;
import com.az9s.hopital.Backend.utils.http.response.UploadResponse;

@RestController
@RequestMapping("/api/file")
public class FileHandlerRestController {
    @Autowired
    private FileHandlerService fileHandlerService;

    /**
     * Upload 1 file (ảnh hoặc pdf) vào module folder
     */
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("module") String moduleFolder
    ) {
        try {
            System.out.println(file.getOriginalFilename());
            String path = fileHandlerService.storeFile(file, moduleFolder);
            return ResponseEntity.ok().body(new UploadResponse("Tải lên thành công", path));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new UploadResponse("Lỗi khi tải lên: " + e.getMessage(), null));
        }
    }

    /**
     * Trả về file đã lưu dưới dạng byte[] (tùy chọn)
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(
            @RequestParam String dir,
            @RequestParam String filename
    ) {
        try {
            byte[] data = fileHandlerService.readFile(dir, filename);
            return ResponseEntity.ok()
                    .contentType(getContentType(filename))
                    .body(data);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Tùy chọn: lấy loại content-type dựa theo đuôi file
    private MediaType getContentType(String filename) {
        if (filename.endsWith(".png")) return MediaType.IMAGE_PNG;
        if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) return MediaType.IMAGE_JPEG;
        if (filename.endsWith(".pdf")) return MediaType.APPLICATION_PDF;
        return MediaType.APPLICATION_OCTET_STREAM;
    }
}
