package ies.thiar.Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class EjerCombinacion {
    /**
     * Realiza una función, de nombre combinacionGanadora que nos va a hacer millonarios. 
     * Tiene que devolver un array ordenado de 6 números no repetidos ente el 1 y el 49. 
     * Para elegir los 6 números sacaremos 
     * al azar cinco millones de número entre el 1 y el 49 y nos quedaremos con los 6 que más han salido.
     */

     public static void main(String[] args) {
        System.out.println(combinacionGanadora());

     }

     public static ArrayList<Integer> combinacionGanadora(){
        //Usamos la clase Collections
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listaNumeros.add(ThreadLocalRandom.current().nextInt(1,50));
        }

        ArrayList<Integer> copiaDeLista = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            copiaDeLista.add(Collections.frequency(listaNumeros, i));
        }
        //El siguente bucle te muestra la cantidad veces ha salido un numero.
        // for (int i = 0; i < copiaDeLista.size(); i++) {
        //     System.out.println(copiaDeLista.get(i));
        // }

        int primero;
        int segundo;
        int tercero;
        int cuarto;
        int quinto;
        int sexto;

        

        primero = Collections.max(copiaDeLista);
        copiaDeLista.remove(copiaDeLista.indexOf(primero));
        
        segundo = Collections.max(copiaDeLista);
        copiaDeLista.remove(copiaDeLista.indexOf(segundo));
        
        tercero = Collections.max(copiaDeLista);
        copiaDeLista.remove(copiaDeLista.indexOf(tercero));
        
        cuarto = Collections.max(copiaDeLista);
        copiaDeLista.remove(copiaDeLista.indexOf(cuarto));
        
        quinto = Collections.max(copiaDeLista);
        copiaDeLista.remove(copiaDeLista.indexOf(quinto));
        
        sexto = Collections.max(copiaDeLista);
        copiaDeLista.remove(copiaDeLista.indexOf(sexto));
       
        //Limpiamos la lista o vaciar
        copiaDeLista.clear();
        //Añadimos los valores maximos ordenados:
        copiaDeLista.add(primero);
        copiaDeLista.add(segundo);
        copiaDeLista.add(tercero);
        copiaDeLista.add(cuarto);
        copiaDeLista.add(quinto);
        copiaDeLista.add(sexto);
        
        //Aqui intento mostrar las veces  que se mostro el mas grande.
        //int cont=0;
        // while (cont < 6) {
        //     System.out.println("Maximos numeros: ");

        //     //int maximo = Collections.max(copiaDeLista);
        //     //System.out.println(maximo);
        //     //copiaDeLista.remove(maximo);
            
        //     System.out.println(primero);
        //     System.out.println(segundo);
        //     System.out.println(tercero);
        //     System.out.println(cuarto);
        //     System.out.println(quinto);
        //     System.out.println(sexto);
        //     cont++;
        // }

        /**
         * El programa devolvera la cantidad de veces que aparece pero no se ve el valor.
         */
        return copiaDeLista;
     }
}