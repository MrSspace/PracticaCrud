package com.NaveEspacial.BarrowRule.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "nave")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Nave implements INave, Serializable {
    
    private static final long serialVersionUID = 1L;
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idNave;

@NotEmpty
private String nombre;

@NotEmpty
private double peso;

@NotEmpty
private String energetico;

@NotEmpty
private String objetivo;

@NotEmpty
private String ubicacion;

@NotEmpty
private boolean activo;

@NotEmpty
private boolean averiado;

    
    @Override
    public void reparar(){}
    
}
