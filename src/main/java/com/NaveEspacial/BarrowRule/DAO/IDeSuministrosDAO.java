package com.NaveEspacial.BarrowRule.DAO;

import com.NaveEspacial.BarrowRule.dominio.DeSuministros;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeSuministrosDAO extends JpaRepository<DeSuministros, Integer>{
    
    @Query(value = "SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave",
            nativeQuery = true)
    public List<DeSuministros> findAllDeSuministros();
    
    @Query(value="SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave "
            + "WHERE nave.nombre = :nombre", nativeQuery=true)
    public List<DeSuministros>findAllDeSuministrosByNombre(@Param("nombre") String nombre);
    
    @Query(value="SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave "
            + "WHERE nave.peso = :peso", nativeQuery=true)
    public List<DeSuministros>findAllDeSuministrosByPeso(@Param("peso") double peso);
    
    @Query(value="SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave "
            + "WHERE nave.energetico = :energetico", nativeQuery=true)
    public List<DeSuministros>findAllDeSuministrosByEnergetico(@Param("energetico") String energetico);
    
    @Query(value="SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave "
            + "WHERE nave.objetivo = :objetivo", nativeQuery=true)
    public List<DeSuministros>findAllDeSuministrosByObjetivo(@Param("objetivo") String objetivo);
    
    @Query(value="SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave "
            + "WHERE nave.ubicacion = :ubicacion", nativeQuery=true)
    public List<DeSuministros>findAllDeSuministrosByUbicacion(@Param("ubicacion") String ubicacion);
    
    @Query(value="SELECT * FROM nave INNER JOIN de_suministros ON nave.id_nave = de_suministros.id_nave "
            + "WHERE de_suministros.capacidad_carga = :capacidadCarga", nativeQuery=true)
    public List<DeSuministros>findAllDeSuministrosByCapacidadCarga(@Param("capacidadCarga") double capacidadCarga);
    
}
