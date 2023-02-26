package com.NaveEspacial.BarrowRule.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorWeb {
    
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
    
    @PostMapping("/buscar")
    public String buscar(String buscado, Model model){
    return "index";
    }
    
}
