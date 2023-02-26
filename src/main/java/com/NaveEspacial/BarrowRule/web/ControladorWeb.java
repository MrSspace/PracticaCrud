package com.NaveEspacial.BarrowRule.web;

import com.NaveEspacial.BarrowRule.dominio.Buscado;
import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import com.NaveEspacial.BarrowRule.service.DeSuministrosService;
import com.NaveEspacial.BarrowRule.service.LanzaderaService;
import com.NaveEspacial.BarrowRule.service.SondaService;
import com.NaveEspacial.BarrowRule.service.TripuladaService;
import static com.NaveEspacial.BarrowRule.utileria.Decisiones.esDouble;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorWeb {
    
    @Autowired
    private LanzaderaService lanzaderaService;
    
    @Autowired
    private TripuladaService tripuladaService;
    
    @Autowired
    private SondaService sondaService;
    
    @Autowired
    private DeSuministrosService deSuministrosService;
    
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
    
    @PostMapping("/buscar")
    public String buscar(Buscado buscado, Model model){
        List<Lanzadera> lanzaderas;
        
        if ( esDouble( buscado.getVariable() ) ) {
            lanzaderas = lanzaderaService.listarLanzaderasPorPeso( Double.parseDouble( buscado.getVariable()) );
            lanzaderas.addAll( lanzaderaService.listarLanzaderasPorAltura( Double.parseDouble( buscado.getVariable()) ) );
        } else {
         lanzaderas = lanzaderaService.listarLanzaderasPorNombre(buscado.getVariable());
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorEnergetico(buscado.getVariable()) );
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorObjetivo(buscado.getVariable()) );
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorUbicacion(buscado.getVariable()) );
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorVehiculoALanzar(buscado.getVariable()) );
        }
        
        model.addAttribute("lanzaderas", lanzaderas);
        
        if (lanzaderas.isEmpty()) {
            return "/busquedaSinResultado";
        } else {
            return "/resultadoBusqueda";
        }
    }
    
}
