package com.NaveEspacial.BarrowRule.web;

import com.NaveEspacial.BarrowRule.dominio.Tripulada;
import com.NaveEspacial.BarrowRule.service.TripuladaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorTripuladas {
    
    @Autowired
    private TripuladaService tripuladaService;
    
    @GetMapping("/tripulada")
    public String mostrarTripuladas(Model model) {
        List<Tripulada> tripuladas = tripuladaService.listarTripuladas();
        model.addAttribute("tripuladas", tripuladas);
        return "./tripuladas/tripuladas";
    }
    
    @GetMapping("/formularioTripuladas")
    public String formularioTripuladas(Tripulada tripulada) {
        return "./tripuladas/formularioTripuladas";
    }
    
    @PostMapping("/guardarTripulada")
    public String guardarTripulada(@Valid Tripulada tripulada, Model model, Errors error){
        if (error.hasErrors()) {
            return "./tripuladas/formularioTripuladas";
        }
        tripuladaService.guardar(tripulada);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/detallesTripuladas";
    }
    
    @GetMapping("/editarTripulada/{idNave}")
    public String editarTripulada(Tripulada tripulada, Model model) {
        tripulada = tripuladaService.encontrarTripulada(tripulada);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/formularioTripuladas";
    }
    
    @GetMapping("/eliminarTripulada")
    public String eliminarTripulada(Tripulada tripulada, Model model) {
        tripuladaService.eliminar(tripulada);
        return mostrarTripuladas(model);
    }
    
    @GetMapping("/detallesTripulada/{idNave}")
    public String detallesTripulada(Tripulada tripulada, Model model) {
        tripulada = tripuladaService.encontrarTripulada(tripulada);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/detallesTripuladas";
    }
    
    @GetMapping("/repararTripulada/{idNave}")
    public String repararTripulada(Tripulada tripulada, Model model) {
        tripulada = tripuladaService.encontrarTripulada(tripulada);
        tripulada.reparar();
        String reparacion = "La nave " + tripulada.getNombre() + " se ha reparado exitosamente";
        tripuladaService.guardar(tripulada);
        model.addAttribute("reparar", reparacion);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/detallesTripuladas";
    }
    
    @GetMapping("activarTripulada/{idNave}")
    public String activarTripulada(Tripulada tripulada, Model model){
        tripulada = tripuladaService.encontrarTripulada(tripulada);
        String activar = tripulada.activar();
        tripuladaService.guardar(tripulada);
        model.addAttribute("activar", activar);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/detallesTripuladas";
    }
    
    @GetMapping("moverTripulada/{idNave}")
    public String moverTripulada(Tripulada tripulada, Model model){
        tripulada = tripuladaService.encontrarTripulada(tripulada);
        String mover = tripulada.mover();
        tripuladaService.guardar(tripulada);
        model.addAttribute("mover", mover);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/detallesTripuladas";
    }
    
    @GetMapping("reiniciarTripulada/{idNave}")
    public String reiniciarTripulada(Tripulada tripulada, Model model){
        tripulada = tripuladaService.encontrarTripulada(tripulada);
        tripulada.reiniciarMision();
        String reinicio = "La nave " + tripulada.getNombre() + " se ha recuperado exitosamente. Recuerda usar el metodo"
                + " Reparar luego de reiniciar la mision ya que en ocasiones la nave puede sufrir averias";
        tripuladaService.guardar(tripulada);
        model.addAttribute("reparar", reinicio);
        model.addAttribute("tripulada", tripulada);
        return "./tripuladas/detallesTripuladas";
    }
    
}
