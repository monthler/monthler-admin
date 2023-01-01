package com.example.monthleradmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MunicipalityController {
    @GetMapping("/dashboard")
    public String getDashboard() {
        return "pages/dashboard";
    }

    @GetMapping("/municipality")
    public String getMunicipality() {
        return "pages/municipality";
    }
}