package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.Tripulada;
import java.util.List;

public interface ITripuladaService {
    
    public List<Tripulada> listarTripuladas();
    public void guardar(Tripulada tripulada);
    public void eliminar(Tripulada tripulada);
    public Tripulada encontrarTripulada(Tripulada tripulada);
    public List<Tripulada> listarTripuladasPorNombre(String nombre);
    public List<Tripulada> listarTripuladasPorPeso(double peso);
    public List<Tripulada> listarTripuladasPorEnergetico(String energetico);
    public List<Tripulada> listarTripuladasPorObjetivo(String objetivo);
    public List<Tripulada> listarTripuladasPorUbicacion(String ubicacion);
    public List<Tripulada> listarTripuladasPorTripulantes(int tripulantes);
    
}
