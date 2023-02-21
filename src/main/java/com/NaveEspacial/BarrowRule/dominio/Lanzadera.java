package com.NaveEspacial.BarrowRule.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "lanzadera")
@PrimaryKeyJoinColumn(name="id_nave")
public class Lanzadera extends Nave implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    @Column(name = "altura")
    private double altura;
    
    @NotEmpty
    @Column(name = "vehiculo_a_lanzar")
    private String vehiculoALanzar;
    
    @NotEmpty
    @Column(name = "lanzado")
    private boolean lanzado;
    
    
    @Override
    public String Activar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
