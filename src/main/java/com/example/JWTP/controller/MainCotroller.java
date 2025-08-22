package com.example.JWTP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainCotroller {

    @GetMapping("/")
    public String mainP() {

        return "Main Controller";
    }
}
