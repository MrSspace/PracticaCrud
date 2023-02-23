package com.NaveEspacial.BarrowRule.dominio;

import static com.NaveEspacial.BarrowRule.utileria.Decisiones.siONoAleatorio;
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
    public String activar() {
        String respuesta = "";
        if ( !this.isActivo() ){
            this.setActivo(true);
            respuesta = "Comenzando secuencia de activacion de la lanzadera " + this.getNombre() + " con destino a " + this.getObjetivo()
                + ". 10... 9... 8... 7... 6... 5... 4... 3... 2... 1... despegue!!... '(Activa nuevamente para continuar o utiliza el metodo mover"
                    + " para ganar un mayor impulso)'";
            this.setUbicacion("Espacio Exterior");
        } else if ( !this.lanzado ) {
            this.lanzado = true;
            respuesta = "Estado de la mision: " + this.getNombre() + " se encuentra: activa..."
                + " Comenzando despliegue de: " + this.getVehiculoALanzar() + ". '(Activa nuevamente para continuar...)'";
        } else {
            respuesta = this.vehiculoALanzar + " se ha desplegado exitosamente. '(Mision cumplida...)'";
        }
        return respuesta;
    }

    @Override
    public String mover() {
        String respuesta = "";
        if ( !this.isActivo() ){
            respuesta = "Moviendo la lanzadera " + this.getNombre() + " del hangar a la plataforma de lanzamiento"
                    + " '( Utiliza el metodo activar para iniciar la nave y realizar un nuevo movimiento...)'";
        } else if ( this.isActivo() ) {
            boolean desviado = siONoAleatorio();
            if(desviado){
                respuesta = "Se ha presentado una situacion inesperada y la nave a perdido el rumbo... "
                        + "(Utiliza el metodo mover para volver a la trayectoria...)";
            } else {
                respuesta = "Aumentando el suministro de " + this.getEnergetico() + " en los motores. Rumbo fijado a: "
                        + this.getObjetivo();
            }
        }
        return respuesta;
    }
    
    @Override
    public void reiniciarMision(){
        this.setActivo(false);
        this.setAveriado(siONoAleatorio());
        this.setLanzado(false);
        this.setUbicacion("Centro Espacial");
    };
    
}
