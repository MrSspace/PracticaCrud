package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import java.util.List;

public interface IDeSuministrosService {
    
    public List<DeSuministros> listarDeSuministros();
    public void guardar(DeSuministros deSuministros);
    public void eliminar(DeSuministros deSuministros);
    public DeSuministros encontrarDeSuministros(DeSuministros deSuministros);
    
}
