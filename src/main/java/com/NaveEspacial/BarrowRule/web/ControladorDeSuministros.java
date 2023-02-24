package com.NaveEspacial.BarrowRule.web;

import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import com.NaveEspacial.BarrowRule.service.DeSuministrosService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorDeSuministros {
    
    @Autowired
    private DeSuministrosService deSuministrosService;
    
    @GetMapping("/deSuministros")
    public String mostrarDeSuministros(Model model) {
        List<DeSuministros> deSuministros = deSuministrosService.listarDeSuministros();
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/deSuministros";
    }
    
    @GetMapping("/formularioDeSuministros")
    public String formularioDeSuministros(DeSuministros deSuministros) {
        return "./deSuministros/formularioDeSuministros";
    }
    
    @PostMapping("/guardarDeSuministros")
    public String guardarDeSuministros(@Valid DeSuministros deSuministros, Model model, Errors error){
        if (error.hasErrors()) {
            return "./deSuministros/formularioDeSuministros";
        }
        deSuministrosService.guardar(deSuministros);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/detallesDeSuministros";
    }
    
    @GetMapping("/editarDeSuministros/{idNave}")
    public String editarDeSuministros(DeSuministros deSuministros, Model model) {
        deSuministros = deSuministrosService.encontrarDeSuministros(deSuministros);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/formularioDeSuministros";
    }
    
    @GetMapping("/eliminarDeSuministros")
    public String eliminarDeSuministros(DeSuministros deSuministros, Model model) {
        deSuministrosService.eliminar(deSuministros);
        return mostrarDeSuministros(model);
    }
    
    @GetMapping("/detallesDeSuministros/{idNave}")
    public String detallesDeSuministros(DeSuministros deSuministros, Model model) {
        deSuministros = deSuministrosService.encontrarDeSuministros(deSuministros);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/detallesDeSuministros";
    }
    
    @GetMapping("/repararDeSuministros/{idNave}")
    public String repararDeSuministros(DeSuministros deSuministros, Model model) {
        deSuministros = deSuministrosService.encontrarDeSuministros(deSuministros);
        deSuministros.reparar();
        String reparacion = "La nave " + deSuministros.getNombre() + " se ha reparado exitosamente";
        deSuministrosService.guardar(deSuministros);
        model.addAttribute("reparar", reparacion);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/detallesDeSuministros";
    }
    
    @GetMapping("activarDeSuministros/{idNave}")
    public String activarDeSuministros(DeSuministros deSuministros, Model model){
        deSuministros = deSuministrosService.encontrarDeSuministros(deSuministros);
        String activar = deSuministros.activar();
        deSuministrosService.guardar(deSuministros);
        model.addAttribute("activar", activar);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/detallesDeSuministros";
    }
    
    @GetMapping("moverDeSuministros/{idNave}")
    public String moverDeSuministros(DeSuministros deSuministros, Model model){
        deSuministros = deSuministrosService.encontrarDeSuministros(deSuministros);
        String mover = deSuministros.mover();
        deSuministrosService.guardar(deSuministros);
        model.addAttribute("mover", mover);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/detallesDeSuministros";
    }
    
    @GetMapping("reiniciarDeSuministros/{idNave}")
    public String reiniciarDeSuministros(DeSuministros deSuministros, Model model){
        deSuministros = deSuministrosService.encontrarDeSuministros(deSuministros);
        deSuministros.reiniciarMision();
        String reinicio = "La nave " + deSuministros.getNombre() + " se ha recuperado exitosamente. Recuerda usar el metodo"
                + " Reparar luego de reiniciar la mision ya que en ocasiones la nave puede sufrir averias";
        deSuministrosService.guardar(deSuministros);
        model.addAttribute("reparar", reinicio);
        model.addAttribute("deSuministros", deSuministros);
        return "./deSuministros/detallesDeSuministros";
    }
    
}
