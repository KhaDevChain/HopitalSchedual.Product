package com.az9s.hopital.Backend.utils.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadResponse {
    private String message;
    private String path;
}
