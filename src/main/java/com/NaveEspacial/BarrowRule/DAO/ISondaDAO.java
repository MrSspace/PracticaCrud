package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Sonda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISondaDAO extends JpaRepository<Sonda, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave",
            nativeQuery=true)
    public List<Sonda> findAllSondas();
    
}
