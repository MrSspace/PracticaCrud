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
    
}
