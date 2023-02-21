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
    public String mostrarLanzaderas(Model model) {
        List<Lanzadera> lanzaderas = lanzaderaService.listarLanzaderas();
        model.addAttribute("lanzaderas", lanzaderas);
        return "./lanzadera/lanzadera";
    }
    
    @GetMapping("/formularioLanzadera")
    public String formularioLanzadera(Lanzadera lanzadera) {
        return "./lanzadera/formularioLanzadera";
    }
    
    @PostMapping("/guardarLanzadera")
    public String guardarLanzadera(@Valid Lanzadera lanzadera, Errors error){
        if (error.hasErrors()) {
            return "./lanzadera/formularioLanzadera";
        }
        lanzaderaService.guardar(lanzadera);
        return "redirect:/";
    }
    
    @GetMapping("/editarLanzadera/{idNave}")
    public String editarLanzadera(Lanzadera lanzadera, Model model) {
        lanzadera = lanzaderaService.encontrarLanzadera(lanzadera);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/formularioLanzadera";
    }
    
    @GetMapping("/eliminarLanzadera")
    public String eliminarLanzadera(Lanzadera lanzadera, Model model) {
        lanzaderaService.eliminar(lanzadera);
        return "redirect:/";
    }
    
    @GetMapping("/detallesLanzadera/{idNave}")
    public String detallesLanzadera(Lanzadera lanzadera, Model model) {
        lanzadera = lanzaderaService.encontrarLanzadera(lanzadera);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/detallesLanzadera";
    }
    
    @GetMapping("/repararLanzadera/{idNave}")
    public String repararLanzadera(Lanzadera lanzadera, Model model) {
        lanzadera = lanzaderaService.encontrarLanzadera(lanzadera);
        lanzadera.reparar();
        lanzaderaService.guardar(lanzadera);
        return "redirect:/";
    }
    
}
