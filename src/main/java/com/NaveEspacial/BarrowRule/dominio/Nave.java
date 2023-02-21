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
@Column(name = "id_nave")
private int idNave;

@NotEmpty
@Column(name = "nombre")
private String nombre;

@NotEmpty
@Column(name = "peso")
private double peso;

@NotEmpty
@Column(name = "energetico")
private String energetico;

@NotEmpty
@Column(name = "objetivo")
private String objetivo;

@NotEmpty
@Column(name = "ubicacion")
private String ubicacion;

@NotEmpty
@Column(name = "activo")
private boolean activo;

@NotEmpty
@Column(name = "averiado")
private boolean averiado;

    
    @Override
    public void reparar(){
        if (this.averiado) {
            this.averiado = false;
            System.out.println("Se reparo la nave con id = " + this.idNave);
        }
    }
    
}
