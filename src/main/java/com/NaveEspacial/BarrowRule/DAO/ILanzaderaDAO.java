package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanzaderaDAO extends JpaRepository<Lanzadera, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave",
            nativeQuery=true)
    public List<Lanzadera> findAllNaves();

}
