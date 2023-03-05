package com.raranguren.relire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseDirController {

    @GetMapping("/api/v1")
    String baseDir1() {
        return "Hello from Relire API v1";
    }

    @GetMapping("/api")
    String baseDir() {
        return "Please use api/v1";
    }

}
