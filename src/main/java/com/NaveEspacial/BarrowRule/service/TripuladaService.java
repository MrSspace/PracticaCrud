package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.DAO.ITripuladaDAO;
import com.NaveEspacial.BarrowRule.dominio.Tripulada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TripuladaService implements ITripuladaService{
    
    @Autowired
    private ITripuladaDAO tripuladaDAO;

    @Override
    @Transactional
    public List<Tripulada> listarTripuladas() {
        return (List<Tripulada>) tripuladaDAO.findAllTripuladas();
    }

    @Override
    @Transactional
    public void guardar(Tripulada tripulada) {
        tripuladaDAO.save(tripulada);
    }

    @Override
    @Transactional
    public void eliminar(Tripulada tripulada) {
        System.out.println("Se ha borrado la tripulada con id = " + tripulada.getIdNave());
        tripuladaDAO.delete(tripulada);
    }

    @Override
    @Transactional(readOnly = true)
    public Tripulada encontrarTripulada(Tripulada tripulada) {
        return tripuladaDAO.findById(tripulada.getIdNave()).orElse(null);
    }

    @Override
    public List<Tripulada> listarTripuladasPorNombre(String nombre) {
        System.out.println("Buscando Tripuladas por nombre = " + nombre);
        return tripuladaDAO.findAllTripuladasByNombre(nombre);
    }

    @Override
    public List<Tripulada> listarTripuladasPorPeso(double peso) {
        System.out.println("Buscando Tripuladas por peso = " + peso);
        return tripuladaDAO.findAllTripuladasByPeso(peso);
    }

    @Override
    public List<Tripulada> listarTripuladasPorEnergetico(String energetico) {
        System.out.println("Buscando Tripuladas por energetico = " + energetico);
        return tripuladaDAO.findAllTripuladasByEnergetico(energetico);
    }

    @Override
    public List<Tripulada> listarTripuladasPorObjetivo(String objetivo) {
        System.out.println("Buscando Tripuladas por objetivo = " + objetivo);
        return tripuladaDAO.findAllTripuladasByObjetivo(objetivo);
    }

    @Override
    public List<Tripulada> listarTripuladasPorUbicacion(String ubicacion) {
        System.out.println("Buscando Tripuladas por ubicacion = " + ubicacion);
        return tripuladaDAO.findAllTripuladasByUbicacion(ubicacion);
    }

    @Override
    public List<Tripulada> listarTripuladasPorTripulantes(int tripulantes) {
        System.out.println("Buscando Tripuladas por tripulantes = " + tripulantes);
        return tripuladaDAO.findAllTripuladasByTripulantes(tripulantes);
    }
    
}
