package com.example._20202330_gtics_lab5.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/principal")
    public String principal(){
        return "muestra_P1";
    }
    // Esto es solo para que se corriera y ya:)
}
