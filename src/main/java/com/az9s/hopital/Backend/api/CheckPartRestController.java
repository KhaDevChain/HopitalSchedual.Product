package com.az9s.hopital.Backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.service.CheckupPartService;

@RestController
@RequestMapping("/api/checkpart")
public class CheckPartRestController {
    @Autowired
    @Qualifier("logicCheckupPartService")
    private CheckupPartService checkupPartService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(checkupPartService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<?> findById(@RequestBody Long id) {
        return ResponseEntity.ok(checkupPartService.findById(id));
    }
    
}
