package com.NaveEspacial.BarrowRule.web;

import com.NaveEspacial.BarrowRule.dominio.Sonda;
import com.NaveEspacial.BarrowRule.service.SondaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorSonda {
    
    @Autowired
    private SondaService sondaService;
    
    @GetMapping("/sonda")
    public String mostrarSondas(Model model) {
        List<Sonda> sondas = sondaService.listarSondas();
        model.addAttribute("sondas", sondas);
        return "./sonda/sonda";
    }
    
    @GetMapping("/formularioSonda")
    public String formularioSonda(Sonda sonda) {
        return "./sonda/formularioSonda";
    }
    
    @PostMapping("/guardarSonda")
    public String guardarSonda(@Valid Sonda sonda, Model model, Errors error){
        if (error.hasErrors()) {
            return "./sonda/formularioSonda";
        }
        sondaService.guardar(sonda);
        model.addAttribute("sonda", sonda);
        return "./sonda/detallesSonda";
    }
    
    @GetMapping("/editarSonda/{idNave}")
    public String editarSonda(Sonda sonda, Model model) {
        sonda = sondaService.encontrarSonda(sonda);
        model.addAttribute("sonda", sonda);
        return "./sonda/formularioSonda";
    }
    
    @GetMapping("/eliminarSonda")
    public String eliminarSonda(Sonda sonda, Model model) {
        sondaService.eliminar(sonda);
        return mostrarSondas(model);
    }
    
    @GetMapping("/detallesSonda/{idNave}")
    public String detallesSonda(Sonda sonda, Model model) {
        sonda = sondaService.encontrarSonda(sonda);
        model.addAttribute("sonda", sonda);
        return "./sonda/detallesSonda";
    }
    
    @GetMapping("/repararSonda/{idNave}")
    public String repararSonda(Sonda sonda, Model model) {
        sonda = sondaService.encontrarSonda(sonda);
        sonda.reparar();
        String reparacion = "La nave " + sonda.getNombre() + " se ha reparado exitosamente";
        sondaService.guardar(sonda);
        model.addAttribute("reparar", reparacion);
        model.addAttribute("sonda", sonda);
        return "./sonda/detallesSonda";
    }
    
    @GetMapping("activarSonda/{idNave}")
    public String activarSonda(Sonda sonda, Model model){
        sonda = sondaService.encontrarSonda(sonda);
        String activar = sonda.activar();
        sondaService.guardar(sonda);
        model.addAttribute("activar", activar);
        model.addAttribute("sonda", sonda);
        return "./sonda/detallesSonda";
    }
    
    @GetMapping("moverSonda/{idNave}")
    public String moverSonda(Sonda sonda, Model model){
        sonda = sondaService.encontrarSonda(sonda);
        String mover = sonda.mover();
        sondaService.guardar(sonda);
        model.addAttribute("mover", mover);
        model.addAttribute("sonda", sonda);
        return "./sonda/detallesSonda";
    }
    
    @GetMapping("reiniciarSonda/{idNave}")
    public String reiniciarSonda(Sonda sonda, Model model){
        sonda = sondaService.encontrarSonda(sonda);
        sonda.reiniciarMision();
        String reinicio = "La nave " + sonda.getNombre() + " se ha recuperado exitosamente. Recuerda usar el metodo"
                + " Reparar luego de reiniciar la mision ya que en ocasiones la nave puede sufrir averias";
        sondaService.guardar(sonda);
        model.addAttribute("reparar", reinicio);
        model.addAttribute("sonda", sonda);
        return "./sonda/detallesSonda";
    }
    
}
