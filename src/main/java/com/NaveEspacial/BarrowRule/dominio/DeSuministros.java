package com.NaveEspacial.BarrowRule.dominio;

import static com.NaveEspacial.BarrowRule.utileria.Decisiones.siONoAleatorio;
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
    @Column(name = "capacidad_carga")
    private double capacidadCarga;
    
    @NotEmpty
    @Column(name = "acoplado")
    private boolean acoplado;
    
    
    @Override
    public String activar() {
        String respuesta = "";
        if( !this.isActivo() ){
            this.setActivo(true);
            respuesta = "Desplegando nave " + this.getNombre() + ". Verificando estado de la nave...";
            if(siONoAleatorio()){
                respuesta = respuesta + " Estado de la nave: Optimo. Ubicacion Actual "+ this.getUbicacion()
                        + "... (Activa nuevamente o mueve la nave para continuar)";
            } else {
                this.setAveriado(true);
                respuesta = respuesta + " La nave requiere reparaciones...";
            }
        } else {
            if( this.isAveriado() ){
                respuesta = "La nave requiere reparaciones!!";
            } else {
                respuesta = "Comenzando secuencia de acoplamiento...";
                if( siONoAleatorio() ){
                    this.setAcoplado(true);
                    this.setActivo(false);
                    respuesta = respuesta + " Acoplamiento completo. Comenzando traslado de suministros... Desactivando nave";
                } else {
                    respuesta = respuesta + " El acoplamiento ha fallado!!";
                }
            }
        }
        return respuesta;
    }

    @Override
    public String mover() {
        return "Desplazando la nave " + this.getNombre() + ". Objetivo: " + this.getObjetivo();
    }
    
    @Override
    public void reiniciarMision(){
        this.setActivo(false);
        this.setAveriado(siONoAleatorio());
        this.setAcoplado(false);
        this.setUbicacion("Centro Espacial");
    };
    
}
