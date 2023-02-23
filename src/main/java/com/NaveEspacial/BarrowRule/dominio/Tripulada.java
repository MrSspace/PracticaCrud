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
    @Column(name = "tripulantes")
    private int tripulantes;
    
    
    @Override
    public String activar() {
        return "EN CONSTRUCCION";
    }

    @Override
    public String mover() {
        return "EN CONSTRUCCION";
    }
    
    @Override
    public void reiniciarMision(){
    
    };
    
}
