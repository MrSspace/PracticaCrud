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
    
}
