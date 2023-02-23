package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.Sonda;
import java.util.List;

public interface ISondaService {
    
    public List<Sonda> listarSondas();
    public void guardar(Sonda sonda);
    public void eliminar(Sonda sonda);
    public Sonda encontrarSonda(Sonda sonda);
    
}
