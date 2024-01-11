package ies.thiar;

import java.util.Scanner;

public class Ejer7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer valor: ");
        int numeroP = teclado.nextInt();
        System.out.println("Introduce el segundo valor: ");
        int numeroQ = teclado.nextInt();

        if (numeroP>numeroQ) {
            int aux;
            aux = numeroP;
            numeroP = numeroQ;
            numeroQ = aux;

            int[] numero = new int[(numeroQ-numeroP)+1];
        
        for (int i = 0; i < numero.length; i++) {
            numero[i]=numeroP;
            System.out.println(numero[i]);
            numeroP++;
        }
        teclado.close();
        }else{
            int[] numero = new int[(numeroQ-numeroP)+1];
        
        for (int i = 0; i < numero.length; i++) {
            numero[i]=numeroP;
            System.out.println(numero[i]);
            numeroP++;
        }
        teclado.close();
        }
    }
}