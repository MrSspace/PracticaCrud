package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanzaderaDAO extends JpaRepository<Lanzadera, Integer>{
    
    
}
