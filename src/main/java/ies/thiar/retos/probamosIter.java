package ies.thiar.retos;

import java.util.ArrayList;
import java.util.Iterator;

public class probamosIter {
    int[][] matriz;
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(5);
        lista.add(3);
        lista.add(1);

        // for (int i = 0; i < 5; i++) {
        //     int numero = ThreadLocalRandom.current().nextInt(0,6);
        //     lista.add(numero);
        //}

        // for (int i = 0; i < lista.size(); i++) {
        //     System.out.println(lista.get(i));
        // }

        //System.out.println(lista.toString());

        Iterator<Integer> iter = lista.iterator();

        // while (iter.hasNext()) {
        //     System.out.println(iter.next());
        // }

        while (iter.hasNext()) {
            Integer i = iter.next();
            if (i == 1) {
                iter.remove();
            }
        }
        
        while (iter.hasNext()) {
             System.out.println(iter.next());
        }

        // for (int i = 0; i < lista.size(); i++) {
        //     System.out.println(lista.get(i));
        // }        
    }
}