package com.NaveEspacial.BarrowRule.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "de_suministros")
@PrimaryKeyJoinColumn(name="id_nave")
public class DeSuministros extends Nave implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    private double capacidadCarga;
    
    @NotEmpty
    private boolean acoplado;
    
    
    @Override
    public String activar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void reiniciarMision(){
    
    };
    
}
