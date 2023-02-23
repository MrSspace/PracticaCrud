package com.NaveEspacial.BarrowRule.dominio;

import static com.NaveEspacial.BarrowRule.utileria.Decisiones.siONoAleatorio;
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
    @Column(name = "destino")
    private String destino;
    
    @NotEmpty
    @Column(name = "transmitiendo")
    private boolean transmitiendo;
    
    
    @Override
    public String activar() {
        String respuesta = "";
        if( !this.isActivo() ){
            this.setActivo(true);
            respuesta = "Activando la sonda " + this.getNombre() + ". Verificando el estado de los sensores...";
            if( siONoAleatorio() ){
                respuesta = respuesta + " Verificacion completa: Todos los sensores en orden";
            } else {
                this.setAveriado(false);
                respuesta = respuesta = " Verificacion completa: La nave se encuentra averiada. Es necesario realizar reparaciones";
            }
        } else {
            respuesta = "La sonda " + this.getNombre() + ". Esta lista para ";
            if( siONoAleatorio() ){
                this.setTransmitiendo(false);
                respuesta = respuesta + " realizar: " + this.getObjetivo() + "Activando sensores correspondientes";
            } else {
                this.setTransmitiendo(true);
                respuesta = respuesta + " transmitir informacion de: " + this.getObjetivo() + "Activando sensores correspondientes";
            }
        }
        return respuesta;
    }

    @Override
    public String mover() {
        String respuesta = "";
        if( !this.isActivo() ){
            respuesta = "La nave " + this.getNombre() + "Aun no se ha desplegado";
        } else {
            if( siONoAleatorio() ){
                respuesta = "Desplazando la nave hacia " + this.getDestino();
            } else {
                this.setAveriado(true);
                respuesta = "Se detectaron averias en la nave. Es requerido reparar";
            }
        }
        return respuesta;
    }
    
    @Override
    public void reiniciarMision(){
        this.setActivo(false);
        this.setAveriado(siONoAleatorio());
        this.setTransmitiendo(false);
        this.setUbicacion("Centro Espacial");
    };
    
}
