package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Sonda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISondaDAO extends JpaRepository<Sonda, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave",
            nativeQuery=true)
    public List<Sonda> findAllSondas();
    
    @Query(value="SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave "
            + "WHERE nave.nombre = :nombre", nativeQuery=true)
    public List<Sonda>findAllSondasByNombre(@Param("nombre") String nombre);
    
    @Query(value="SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave "
            + "WHERE nave.peso = :peso", nativeQuery=true)
    public List<Sonda>findAllSondasByPeso(@Param("peso") double peso);
    
    @Query(value="SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave "
            + "WHERE nave.energetico = :energetico", nativeQuery=true)
    public List<Sonda>findAllSondasByEnergetico(@Param("energetico") String energetico);
    
    @Query(value="SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave "
            + "WHERE nave.objetivo = :objetivo", nativeQuery=true)
    public List<Sonda>findAllSondasByObjetivo(@Param("objetivo") String objetivo);
    
    @Query(value="SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave "
            + "WHERE nave.ubicacion = :ubicacion", nativeQuery=true)
    public List<Sonda>findAllSondasByUbicacion(@Param("ubicacion") String ubicacion);
    
    @Query(value="SELECT * FROM nave INNER JOIN sonda ON nave.id_nave = sonda.id_nave "
            + "WHERE sonda.destino = :destino", nativeQuery=true)
    public List<Sonda>findAllSondasByDestino(@Param("destino") String destino);
    
}
