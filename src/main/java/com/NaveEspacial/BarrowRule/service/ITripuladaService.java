package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.Tripulada;
import java.util.List;

public interface ITripuladaService {
    
    public List<Tripulada> listarTripuladas();
    public void guardar(Tripulada tripulada);
    public void eliminar(Tripulada tripulada);
    public Tripulada encontrarTripulada(Tripulada tripulada);
    
}
