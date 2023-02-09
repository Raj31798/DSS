package com.skii.skiiproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcomecontroller {

    @GetMapping("/welcow")
    public String Welcow()
    {
        return "Welocome ki";
    }
    @GetMapping("/test")
    public String test()
    {
        return "Welocome test";
    }

//    @GetMapping("html page")

    @GetMapping("/shit")
    public String shit()
    {
        return "ufff";
    }

}


