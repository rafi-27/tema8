package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class EjerDivosores {
    public static void main(String[] args) {
        /**
         * Realizar un programa que tenga una función a la que se le pasa un entero y devuelva un
         * ArrayList con todos sus divisores
         */
         Scanner teclado = new Scanner(System.in);
         int n = teclado.nextInt();
         System.out.println(divisores(n));
    }

    public static ArrayList<Integer> divisores(int numero){
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 1; i < numero; i++) {
            if (numero%i==0) lista.add(i);
        }
        return lista;
    }
}
