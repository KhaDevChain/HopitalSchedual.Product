package com.az9s.hopital.Backend.utils.http.response;

import java.time.LocalDateTime;
import java.util.List;

import com.az9s.hopital.Backend.entity.Hopital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HopitalResponse {
    private String message;
    private Hopital hopital;
    private LocalDateTime createdAt;
    private List<Hopital> hopitals;

    public HopitalResponse(String message, Hopital hopital) {
        this.message = message;
        this.hopital = hopital;
        this.createdAt = LocalDateTime.now();
        this.hopitals = null;
    }

    public HopitalResponse(String message, List<Hopital> hopitals) {
        this.message = message;
        this.hopitals = hopitals;
        this.createdAt = LocalDateTime.now();
        this.hopital = null;
    }
}
