package com.example.demo778;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
     @RequestMapping("/")
    public String homePage() {
        return "index";
    }
}
