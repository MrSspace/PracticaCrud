package com.NaveEspacial.BarrowRule.dominio;

import static com.NaveEspacial.BarrowRule.utileria.Decisiones.siONoAleatorio;
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
        String respuesta = "";
        if( !this.isActivo() ){
            this.setActivo(true);
            respuesta = "Comenzando secuencia de activacion... Separando la nave. La " + this.getNombre() +
                    " Se encunetra desplegada para continuar con la mision: " + this.getObjetivo() + 
                    " '(Para continuar utiliza los metodos Mover o Activar)'";
            this.setUbicacion("Espacio Exterior");
        } else if ( this.isActivo() && !this.isAveriado() ){
                respuesta = "El equipo de la " + this.getNombre() + " cuenta con " + this.getTripulantes() + " tripulantes"
                    + " los cuales se encuentran enfocados en la mision: " + this.getObjetivo() +
                     " '(Para continuar utiliza los metodos Mover o Activar)'";
        } else if ( this.isActivo() && this.isAveriado() ) {
                respuesta = "ALERTA!! Se han detectado averias en la nave. Utiliza el metodo Reparar para reestablecer el estado.";
        }
        return respuesta;
    }

    @Override
    public String mover() {
        String respuesta = "";
        if( !siONoAleatorio() && this.isActivo()){
            respuesta = "La " + this.getNombre() + " esta orbitando en torno a " + this.getObjetivo();
        } else if ( this.isActivo() ){
            respuesta = "Redireccionando. La velocidad de la nave se ha incrementado";
            this.setAveriado(siONoAleatorio());
            if(this.isAveriado()){
                respuesta = respuesta + ". Algo ha salido mal... Se presentan averias. Se requieren reparaciones";
            }
        } else if ( !this.isActivo() ){
            respuesta = "Esperando el despliegue y activacion de la " + this.getNombre();
        }
        return respuesta;
    }
    
    @Override
    public void reiniciarMision(){
        this.setActivo(false);
        this.setAveriado(siONoAleatorio());
        this.setUbicacion("Centro Espacial");
    };
    
}
