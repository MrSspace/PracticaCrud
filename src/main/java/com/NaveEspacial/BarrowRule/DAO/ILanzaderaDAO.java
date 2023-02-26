package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.Lanzadera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanzaderaDAO extends JpaRepository<Lanzadera, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave",
            nativeQuery=true)
    public List<Lanzadera> findAllLanzaderas();
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE nave.nombre = :nombre", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByNombre(@Param("nombre") String nombre);
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE nave.peso = :peso", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByPeso(@Param("peso") double peso);
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE nave.energetico = :energetico", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByEnergetico(@Param("energetico") String energetico);
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE nave.objetivo = :objetivo", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByObjetivo(@Param("objetivo") String objetivo);
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE nave.ubicacion = :ubicacion", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByUbicacion(@Param("ubicacion") String ubicacion);
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE lanzadera.altura = :altura", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByAltura(@Param("altura") double altura);
    
    @Query(value="SELECT * FROM nave INNER JOIN lanzadera ON nave.id_nave = lanzadera.id_nave "
            + "WHERE lanzadera.vehiculo_a_lanzar = :vehiculoALanzar", nativeQuery=true)
    public List<Lanzadera>findAllLanzaderasByVehiculoALanzar(@Param("vehiculoALanzar") String vehiculoALanzar);

}
