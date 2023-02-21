package com.NaveEspacial.BarrowRule.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "sonda")
@PrimaryKeyJoinColumn(name="id_nave")
public class Sonda extends Nave implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotEmpty
    private String destino;
    
    @NotEmpty
    private boolean transmitiendo;
    
    
    @Override
    public String Activar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
