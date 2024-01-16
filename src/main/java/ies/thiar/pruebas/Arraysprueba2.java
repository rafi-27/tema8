package ies.thiar.pruebas;

import java.util.ArrayList;

public class Arraysprueba2 {
    public static void main(String[] args) {
        ArrayList<Double>lista = new ArrayList<>();

        lista.add(3.14);
        lista.add(4.15);
        lista.add(3.14);
        lista.add(3.14);
        lista.add(3.14);

        int cont=0;

        System.out.println(lista.toString());
        System.out.println("Tamaño: "+lista.size());
        double numero = 3.14;
        for (int i = 0; i < lista.size()+1; i++) {
            if (lista.get(i)==numero) {
                lista.remove(i);
                cont++;
            }else{
                System.err.println("sa jodio");
            }
        }
        System.out.println("Cont: "+cont);
        System.out.println("Lista actualizada: ");
        System.out.println(lista.toString());

    }
}
