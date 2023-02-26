package com.NaveEspacial.BarrowRule.utileria;

import com.NaveEspacial.BarrowRule.dominio.Nave;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Acciones {
    
    public static List<Nave> ordenarNaves(Nave naves[]){
        List<Nave> ordenadas = new ArrayList<>(Arrays.asList(naves));
        Collections.sort( ordenadas, (Nave nave1, Nave nave2) ->
                new Integer( nave2.getIdNave() ).compareTo( new Integer( nave1.getIdNave() ) ) 
        );
        return ordenadas;
    }
    
}
