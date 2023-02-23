package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Tripulada;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripuladaDAO extends JpaRepository<Tripulada, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave",
            nativeQuery=true)
    public List<Tripulada> findAllTripuladas();
    
}
