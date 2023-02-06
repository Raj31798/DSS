package com.skii.skiiproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcomecontroller {

    @GetMapping("/welcow")
    public String Welcow()
    {
        return "Welocome raki";
    }
    @GetMapping("/shit")
    public String shit()
    {
        return "ufff";
    }

}


