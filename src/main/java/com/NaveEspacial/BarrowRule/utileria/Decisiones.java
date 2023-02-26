package com.NaveEspacial.BarrowRule.utileria;

public class Decisiones {
    
    public static boolean siONoAleatorio(){
        boolean decision = false;
        int num = (int) (Math.random() * 2);
        if(num >= 1){
            decision = true;
        }
        return decision;
    }
    
    public static boolean esDouble(String cadena) {
        boolean verificado;
        try {
            Double.parseDouble(cadena);
            verificado = true;
        } catch (NumberFormatException excepcion) {
            verificado = false;
        }
        return verificado;
    }
    
}
