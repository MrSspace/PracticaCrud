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
    public String guardarLanzadera(@Valid Lanzadera lanzadera, Model model, Errors error){
        if (error.hasErrors()) {
            return "./lanzadera/formularioLanzadera";
        }
        lanzaderaService.guardar(lanzadera);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/detallesLanzadera";
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
        mostrarLanzaderas(model);
        return mostrarLanzaderas(model);
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
        String reparacion = "La nave " + lanzadera.getNombre() + " se ha reparado exitosamente";
        lanzaderaService.guardar(lanzadera);
        model.addAttribute("reparar", reparacion);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/detallesLanzadera";
    }
    
    @GetMapping("activarLanzadera/{idNave}")
    public String activarLanzadera(Lanzadera lanzadera, Model model){
        lanzadera = lanzaderaService.encontrarLanzadera(lanzadera);
        String activar = lanzadera.activar();
        lanzaderaService.guardar(lanzadera);
        model.addAttribute("activar", activar);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/detallesLanzadera";
    }
    
    @GetMapping("moverLanzadera/{idNave}")
    public String moverLanzadera(Lanzadera lanzadera, Model model){
        lanzadera = lanzaderaService.encontrarLanzadera(lanzadera);
        String mover = lanzadera.mover();
        lanzaderaService.guardar(lanzadera);
        model.addAttribute("mover", mover);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/detallesLanzadera";
    }
    
    @GetMapping("reiniciarLanzadera/{idNave}")
    public String reiniciarLanzadera(Lanzadera lanzadera, Model model){
        lanzadera = lanzaderaService.encontrarLanzadera(lanzadera);
        lanzadera.reiniciarMision();
        String reinicio = "La nave " + lanzadera.getNombre() + " se ha recuperado exitosamente. Recuerda usar el metodo"
                + " Reparar luego de reiniciar la mision ya que en ocasiones la nave puede sufrir averias";
        lanzaderaService.guardar(lanzadera);
        model.addAttribute("reparar", reinicio);
        model.addAttribute("lanzadera", lanzadera);
        return "./lanzadera/detallesLanzadera";
    }
    
}
