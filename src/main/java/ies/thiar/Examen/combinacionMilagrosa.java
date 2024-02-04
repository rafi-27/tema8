package ies.thiar.Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class combinacionMilagrosa {
    public static int[] combinacionGanadora(){
        //Usamos la clase Collections
        int[] arrayDeSeisNumeros = new int[6];

        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = 0; i < 50000000; i++) {
            listaNumeros.add(ThreadLocalRandom.current().nextInt(1,50));
        }

        ArrayList<Integer> copiaDeLista = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            copiaDeLista.add(Collections.frequency(listaNumeros, i));
        }
        int[] vecesSalido = new int[6];
        for (int i = 0; i < arrayDeSeisNumeros.length; i++) {
            int maximo = Collections.max(copiaDeLista);
            vecesSalido[i] = maximo;
            int numeroS = copiaDeLista.indexOf(maximo);
            arrayDeSeisNumeros[i]=numeroS;
            copiaDeLista.remove(copiaDeLista.indexOf(maximo));
        }
        for (int i = 0; i < arrayDeSeisNumeros.length; i++) {
                System.out.println(arrayDeSeisNumeros[i]+" ha salido "+vecesSalido[i]+" veces.");
        }
        return arrayDeSeisNumeros;
    }

    public static void main(String[] args) {
        System.out.println(combinacionGanadora());
    }
}