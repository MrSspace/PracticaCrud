package com.NaveEspacial.BarrowRule.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "tripulada")
@PrimaryKeyJoinColumn(name="id_nave")
public class Tripulada extends Nave implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    private int tripulantes;
    
    
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
