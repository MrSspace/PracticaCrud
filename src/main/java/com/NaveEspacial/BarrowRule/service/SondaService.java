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

    @Override
    public List<Sonda> listarSondasPorNombre(String nombre) {
        System.out.println("Buscando Sondas por nombre = " + nombre);
        return sondaDAO.findAllSondasByNombre(nombre);
    }

    @Override
    public List<Sonda> listarSondasPorPeso(double peso) {
        System.out.println("Buscando Sondas por peso = " + peso);
        return sondaDAO.findAllSondasByPeso(peso);
    }

    @Override
    public List<Sonda> listarSondasPorEnergetico(String energetico) {
        System.out.println("Buscando Sondas por energetico = " + energetico);
        return sondaDAO.findAllSondasByEnergetico(energetico);
    }

    @Override
    public List<Sonda> listarSondasPorObjetivo(String objetivo) {
        System.out.println("Buscando Sondas por objetivo = " + objetivo);
        return sondaDAO.findAllSondasByObjetivo(objetivo);
    }

    @Override
    public List<Sonda> listarSondasPorUbicacion(String ubicacion) {
        System.out.println("Buscando Sondas por ubicacion = " + ubicacion);
        return sondaDAO.findAllSondasByUbicacion(ubicacion);
    }

    @Override
    public List<Sonda> listarSondasPorDestino(String destino) {
        System.out.println("Buscando Sondas por destino = " + destino);
        return sondaDAO.findAllSondasByDestino(destino);
    }
    
}
