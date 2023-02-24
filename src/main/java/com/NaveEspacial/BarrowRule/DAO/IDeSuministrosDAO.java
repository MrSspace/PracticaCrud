package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeSuministrosDAO extends JpaRepository<DeSuministros, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave",
            nativeQuery = true)
    public List<DeSuministros> findAllDeSuministros();
    
}
