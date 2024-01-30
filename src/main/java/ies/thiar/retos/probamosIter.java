package ies.thiar.retos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class probamosIter {
    int[][] matriz;
    public static void main(String[] args) {
        probamosIter juego = new probamosIter();
        int[][] matriz = new int[5][5];

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(5);
        lista.add(3);
        lista.add(1);

        // for (int i = 0; i < 5; i++) {
        //     int numero = ThreadLocalRandom.current().nextInt(0,6);
        //     lista.add(numero);
        // }

        Iterator<Integer> iter = lista.iterator();

        while (iter.hasNext()) {
            if (iter.next() == 1) {
                iter.remove();
            }
        }

        // for (int i = 0; i < lista.size(); i++) {
        //     System.out.println(lista.get(i));
        // }

        while (iter.hasNext()) {
            System.out.println(iter);
        }
    }
}