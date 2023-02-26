package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.Sonda;
import java.util.List;

public interface ISondaService {
    
    public List<Sonda> listarSondas();
    public void guardar(Sonda sonda);
    public void eliminar(Sonda sonda);
    public Sonda encontrarSonda(Sonda sonda);
    public List<Sonda> listarSondasPorNombre(String nombre);
    public List<Sonda> listarSondasPorPeso(double peso);
    public List<Sonda> listarSondasPorEnergetico(String energetico);
    public List<Sonda> listarSondasPorObjetivo(String objetivo);
    public List<Sonda> listarSondasPorUbicacion(String ubicacion);
    public List<Sonda> listarSondasPorDestino(String destino);
    
}
