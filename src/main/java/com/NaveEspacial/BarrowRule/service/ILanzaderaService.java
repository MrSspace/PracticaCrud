package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import java.util.List;

public interface ILanzaderaService {
    
    public List<Lanzadera> listarLanzaderas();
    public void guardar(Lanzadera lanzadera);
    public void eliminar(Lanzadera lanzadera);
    public Lanzadera encontrarLanzadera(Lanzadera lanzadera);
    
}
