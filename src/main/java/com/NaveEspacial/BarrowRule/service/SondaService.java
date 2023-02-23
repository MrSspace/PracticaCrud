package com.NaveEspacial.BarrowRule.service;

import com.NaveEspacial.BarrowRule.DAO.ISondaDAO;
import com.NaveEspacial.BarrowRule.dominio.Sonda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SondaService implements ISondaService{
    
    @Autowired
    private ISondaDAO sondaDAO;

    @Override
    @Transactional
    public List<Sonda> listarSondas() {
        return (List<Sonda>) sondaDAO.findAllSondas();
    }

    @Override
    @Transactional
    public void guardar(Sonda sonda) {
        sondaDAO.save(sonda);
    }

    @Override
    @Transactional
    public void eliminar(Sonda sonda) {
        System.out.println("Se ha borrado la sonda con id = " + sonda.getIdNave());
        sondaDAO.delete(sonda);
    }

    @Override
    @Transactional(readOnly = true)
    public Sonda encontrarSonda(Sonda sonda) {
        return sondaDAO.findById(sonda.getIdNave()).orElse(null);
    }
    
}
