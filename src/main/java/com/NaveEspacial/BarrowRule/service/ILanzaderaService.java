package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import java.util.List;

public interface ILanzaderaService {
    
    public List<Lanzadera> listarLanzaderas();
    public void guardar(Lanzadera lanzadera);
    public void eliminar(Lanzadera lanzadera);
    public Lanzadera encontrarLanzadera(Lanzadera lanzadera);
    public List<Lanzadera> listarLanzaderasPorNombre(String nombre);
    public List<Lanzadera> listarLanzaderasPorPeso(double peso);
    public List<Lanzadera> listarLanzaderasPorEnergetico(String energetico);
    public List<Lanzadera> listarLanzaderasPorObjetivo(String objetivo);
    public List<Lanzadera> listarLanzaderasPorUbicacion(String ubicacion);
    public List<Lanzadera> listarLanzaderasPorAltura(double altura);
    public List<Lanzadera> listarLanzaderasPorVehiculoALanzar(String vehiculoALanzar);
    
}
