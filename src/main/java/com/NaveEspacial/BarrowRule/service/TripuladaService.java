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
    
}
