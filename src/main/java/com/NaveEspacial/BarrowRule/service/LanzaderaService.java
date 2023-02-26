package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.DAO.ILanzaderaDAO;
import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanzaderaService implements ILanzaderaService{
    
    @Autowired
    private ILanzaderaDAO lanzaderaDAO;

    @Override
    @Transactional
    public List<Lanzadera> listarLanzaderas() {
        return  (List<Lanzadera>) lanzaderaDAO.findAllLanzaderas();
    }

    @Override
    @Transactional
    public void guardar(Lanzadera lanzadera) {
        lanzaderaDAO.save(lanzadera);
    }

    @Override
    @Transactional
    public void eliminar(Lanzadera lanzadera) {
        System.out.println("Se ha borrado la lanzadera con id = " + lanzadera.getIdNave());
        lanzaderaDAO.delete(lanzadera);
    }

    @Override
    @Transactional(readOnly = true)
    public Lanzadera encontrarLanzadera(Lanzadera lanzadera) {
        return lanzaderaDAO.findById(lanzadera.getIdNave()).orElse(null);
    }
    
    @Override
    @Transactional
    public List<Lanzadera> listarLanzaderasPorNombre(String nombre){
        System.out.println("Buscando Lanzaderas por nombre = " + nombre);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByNombre(nombre);
        return lista;
    }

    @Override
    public List<Lanzadera> listarLanzaderasPorPeso(double peso) {
        System.out.println("Buscando Lanzaderas por peso = " + peso);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByPeso(peso);
        return lista;
    }

    @Override
    public List<Lanzadera> listarLanzaderasPorEnergetico(String energetico) {
        System.out.println("Buscando Lanzaderas por energetico = " + energetico);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByEnergetico(energetico);
        return lista;
    }

    @Override
    public List<Lanzadera> listarLanzaderasPorObjetivo(String objetivo) {
        System.out.println("Buscando Lanzaderas por objetivo = " + objetivo);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByObjetivo(objetivo);
        return lista;
    }

    @Override
    public List<Lanzadera> listarLanzaderasPorUbicacion(String ubicacion) {
        System.out.println("Buscando Lanzaderas por ubicacion = " + ubicacion);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByUbicacion(ubicacion);
        return lista;
    }

    @Override
    public List<Lanzadera> listarLanzaderasPorAltura(double altura) {
        System.out.println("Buscando Lanzaderas por altura = " + altura);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByAltura(altura);
        return lista;
    }

    @Override
    public List<Lanzadera> listarLanzaderasPorVehiculoALanzar(String vehiculoALanzar) {
        System.out.println("Buscando Lanzaderas por vehiculoALanzar = " + vehiculoALanzar);
        List<Lanzadera> lista = (List<Lanzadera>) lanzaderaDAO.findAllLanzaderasByVehiculoALanzar(vehiculoALanzar);
        return lista;
    }
    
}
