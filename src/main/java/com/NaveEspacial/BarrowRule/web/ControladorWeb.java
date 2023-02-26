package com.NaveEspacial.BarrowRule.web;

import com.NaveEspacial.BarrowRule.dominio.Buscado;
import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import com.NaveEspacial.BarrowRule.dominio.Sonda;
import com.NaveEspacial.BarrowRule.dominio.Tripulada;
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
        List<Lanzadera> lanzaderas = null;
        List<Tripulada> tripuladas = null;
        List<Sonda> sondas = null;
        List<DeSuministros> deSuministros = null;
        
        if ( esDouble( buscado.getVariable() ) ) {
            lanzaderas = lanzaderaService.listarLanzaderasPorPeso( Double.parseDouble( buscado.getVariable()) );
            lanzaderas.addAll( lanzaderaService.listarLanzaderasPorAltura( Double.parseDouble( buscado.getVariable()) ) );
            
            tripuladas = tripuladaService.listarTripuladasPorPeso( Double.parseDouble( buscado.getVariable() ) );
            tripuladas.addAll( tripuladaService.listarTripuladasPorTripulantes( Integer.parseInt( buscado.getVariable() ) ) );
            
            sondas = sondaService.listarSondasPorPeso( Double.parseDouble( buscado.getVariable() ) );
            
            deSuministros = deSuministrosService.listarDeSuministrosPorPeso( Double.parseDouble( buscado.getVariable() ) );
            deSuministros.addAll( deSuministrosService.listarDeSuministrosPorCapacidadDeCarga( Double.parseDouble( buscado.getVariable() ) ) );
            
        } else {
         lanzaderas = lanzaderaService.listarLanzaderasPorNombre(buscado.getVariable());
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorEnergetico(buscado.getVariable()) );
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorObjetivo(buscado.getVariable()) );
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorUbicacion(buscado.getVariable()) );
         lanzaderas.addAll( lanzaderaService.listarLanzaderasPorVehiculoALanzar(buscado.getVariable()) );
         
         tripuladas = tripuladaService.listarTripuladasPorNombre(buscado.getVariable());
         tripuladas.addAll( tripuladaService.listarTripuladasPorEnergetico(buscado.getVariable()) );
         tripuladas.addAll( tripuladaService.listarTripuladasPorObjetivo(buscado.getVariable()) );
         tripuladas.addAll( tripuladaService.listarTripuladasPorUbicacion(buscado.getVariable()) );
         
         sondas = sondaService.listarSondasPorNombre(buscado.getVariable());
         sondas.addAll( sondaService.listarSondasPorEnergetico(buscado.getVariable()) );
         sondas.addAll( sondaService.listarSondasPorObjetivo(buscado.getVariable()) );
         sondas.addAll( sondaService.listarSondasPorUbicacion(buscado.getVariable()) );
         sondas.addAll( sondaService.listarSondasPorDestino(buscado.getVariable()) );
         
         deSuministros = deSuministrosService.listarDeSuministrosPorNombre(buscado.getVariable());
         deSuministros.addAll( deSuministrosService.listarDeSuministrosPorEnergetico(buscado.getVariable()) );
         deSuministros.addAll( deSuministrosService.listarDeSuministrosPorObjetivo(buscado.getVariable()) );
         deSuministros.addAll( deSuministrosService.listarDeSuministrosPorUbicacion(buscado.getVariable()) );
        }
        
        model.addAttribute("lanzaderas", lanzaderas);
        model.addAttribute("tripuladas", tripuladas);
        model.addAttribute("sondas", sondas);
        model.addAttribute("deSuministros", deSuministros);
        
        if ( lanzaderas.isEmpty() && tripuladas.isEmpty() && sondas.isEmpty() && deSuministros.isEmpty() ) {
            return "/busquedaSinResultado";
        } else {
            return "/resultadoBusqueda";
        }
    }
    
}
