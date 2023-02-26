package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Tripulada;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripuladaDAO extends JpaRepository<Tripulada, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave",
            nativeQuery=true)
    public List<Tripulada> findAllTripuladas();
    
    @Query(value="SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave "
            + "WHERE nave.nombre = :nombre", nativeQuery=true)
    public List<Tripulada>findAllTripuladasByNombre(@Param("nombre") String nombre);
    
    @Query(value="SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave "
            + "WHERE nave.peso = :peso", nativeQuery=true)
    public List<Tripulada>findAllTripuladasByPeso(@Param("peso") double peso);
    
    @Query(value="SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave "
            + "WHERE nave.energetico = :energetico", nativeQuery=true)
    public List<Tripulada>findAllTripuladasByEnergetico(@Param("energetico") String energetico);
    
    @Query(value="SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave "
            + "WHERE nave.objetivo = :objetivo", nativeQuery=true)
    public List<Tripulada>findAllTripuladasByObjetivo(@Param("objetivo") String objetivo);
    
    @Query(value="SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave "
            + "WHERE nave.ubicacion = :ubicacion", nativeQuery=true)
    public List<Tripulada>findAllTripuladasByUbicacion(@Param("ubicacion") String ubicacion);
    
    @Query(value="SELECT * FROM nave INNER JOIN tripulada ON nave.id_nave = tripulada.id_nave "
            + "WHERE tripulada.tripulantes = :tripulantes", nativeQuery=true)
    public List<Tripulada>findAllTripuladasByTripulantes(@Param("tripulantes") int tripulantes);
    
}
