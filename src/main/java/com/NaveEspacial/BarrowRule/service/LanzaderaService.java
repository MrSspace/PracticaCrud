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
        return  (List<Lanzadera>) lanzaderaDAO.findAllNaves();
    }

    @Override
    @Transactional
    public void guardar(Lanzadera lanzadera) {
        lanzaderaDAO.save(lanzadera);
    }

    @Override
    @Transactional
    public void eliminar(Lanzadera lanzadera) {
        lanzaderaDAO.delete(lanzadera);
    }

    @Override
    @Transactional(readOnly = true)
    public Lanzadera encontrarLanzadera(Lanzadera lanzadera) {
        return lanzaderaDAO.findById(lanzadera.getIdNave()).orElse(null); //modiificar metodo para buscar por cualquier parametro
    }
    
}
