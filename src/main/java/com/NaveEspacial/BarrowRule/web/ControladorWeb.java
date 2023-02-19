package com.NaveEspacial.BarrowRule.web;

import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import com.NaveEspacial.BarrowRule.service.LanzaderaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorWeb {
    
    @Autowired
    private LanzaderaService lanzaderaService;
    
    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/lanzadera")
    public String visitarLanzadera(Model model) {
        List<Lanzadera> lanzaderas = lanzaderaService.listarLanzaderas();
        model.addAttribute("lanzaderas", lanzaderas);
        return "lanzadera";
    }
    
    @GetMapping("/formularioLanzadera")
    public String visitarLanzadera() {
      //List<Lanzadera> lanzaderas = lanzaderaService.listarLanzaderas();
       //model.addAttribute("lanzaderas", lanzaderas);
        return "formularioLanzadera";
    }
    
    @PostMapping("/guardarLanzadera")
    public String guardarLanzadera(@Valid Lanzadera lanzadera, Errors error){
        if (error.hasErrors()) {
            return "lanzadera"; //FormularioLanzadera
        }
        return "redirect:/lanzadera";
    }
    
}
