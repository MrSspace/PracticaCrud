package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INaveDAO extends JpaRepository<Nave, Integer>{
    
}
