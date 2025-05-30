package com.az9s.hopital.Backend.utils.http.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicResponse {
    private String message = null;
    private int status = -1;
    private Object data = null;

    public BasicResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.data = null;
    }
}
