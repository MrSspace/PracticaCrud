package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.DAO.IDeSuministrosDAO;
import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeSuministrosService implements IDeSuministrosService{

    @Autowired
    private IDeSuministrosDAO deSuministrosDAO;
    
    @Override
    public List<DeSuministros> listarDeSuministros() {
        return (List<DeSuministros>) deSuministrosDAO.findAllDeSuministros();
    }

    @Override
    public void guardar(DeSuministros deSuministros) {
        deSuministrosDAO.save(deSuministros);
    }

    @Override
    public void eliminar(DeSuministros deSuministros) {
        System.out.println("Se ha borrado la deSuministros con id = " + deSuministros.getIdNave());
        deSuministrosDAO.delete(deSuministros);
    }

    @Override
    public DeSuministros encontrarDeSuministros(DeSuministros deSuministros) {
        return deSuministrosDAO.findById(deSuministros.getIdNave()).orElse(null);
    }

    @Override
    public List<DeSuministros> listarDeSuministrosPorNombre(String nombre) {
        System.out.println("Buscando De Suministros por nombre = " + nombre);
        return deSuministrosDAO.findAllDeSuministrosByNombre(nombre);
    }

    @Override
    public List<DeSuministros> listarDeSuministrosPorPeso(double peso) {
        System.out.println("Buscando De Suministros por peso = " + peso);
        return deSuministrosDAO.findAllDeSuministrosByPeso(peso);
    }

    @Override
    public List<DeSuministros> listarDeSuministrosPorEnergetico(String energetico) {
        System.out.println("Buscando De Suministros por energetico = " + energetico);
        return deSuministrosDAO.findAllDeSuministrosByEnergetico(energetico);
    }

    @Override
    public List<DeSuministros> listarDeSuministrosPorObjetivo(String objetivo) {
        System.out.println("Buscando De Suministros por objetivo = " + objetivo);
        return deSuministrosDAO.findAllDeSuministrosByObjetivo(objetivo);
    }

    @Override
    public List<DeSuministros> listarDeSuministrosPorUbicacion(String ubicacion) {
        System.out.println("Buscando De Suministros por ubicacion = " + ubicacion);
        return deSuministrosDAO.findAllDeSuministrosByUbicacion(ubicacion);
    }

    @Override
    public List<DeSuministros> listarDeSuministrosPorCapacidadDeCarga(double capacidadCarga) {
        System.out.println("Buscando De Suministros por capacidad de carga = " + capacidadCarga);
        return deSuministrosDAO.findAllDeSuministrosByCapacidadCarga(capacidadCarga);
    }
    
}
