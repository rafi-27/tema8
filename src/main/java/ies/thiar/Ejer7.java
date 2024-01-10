package ies.thiar;

import java.util.Scanner;

public class Ejer7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer valor: ");
        int numeroP = teclado.nextInt();
        System.out.println("Introduce el segundo valor: ");
        int numeroQ = teclado.nextInt();

        if (numeroQ<numeroP) {
            int aux;
            aux = numeroP;
            numeroQ = numeroP;
            numeroP = aux;
        }

        int[] numero = new int[(numeroQ-numeroP)];
        
        for (int i = 0; i < numero.length; i++) {
            numero[i]=numeroP;
            System.out.println(numero[i]);
            numeroP++;
        }
        teclado.close();
    }
}
