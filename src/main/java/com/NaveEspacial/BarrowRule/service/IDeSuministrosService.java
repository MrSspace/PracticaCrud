package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import java.util.List;

public interface IDeSuministrosService {
    
    public List<DeSuministros> listarDeSuministros();
    public void guardar(DeSuministros deSuministros);
    public void eliminar(DeSuministros deSuministros);
    public DeSuministros encontrarDeSuministros(DeSuministros deSuministros);
    public List<DeSuministros> listarDeSuministrosPorNombre(String nombre);
    public List<DeSuministros> listarDeSuministrosPorPeso(double peso);
    public List<DeSuministros> listarDeSuministrosPorEnergetico(String energetico);
    public List<DeSuministros> listarDeSuministrosPorObjetivo(String objetivo);
    public List<DeSuministros> listarDeSuministrosPorUbicacion(String ubicacion);
    public List<DeSuministros> listarDeSuministrosPorCapacidadDeCarga(double capacidadCarga);
    
}
