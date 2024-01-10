package ies.thiar;

import java.util.Scanner;

public class Ejer6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Creamos un array N que sera el tamaño del array y M sera escrita en sus posiciones.
        System.out.println("Numero N");
        int[] numeroN = new int[teclado.nextInt()];
        System.out.println("Numero M");
        int numeroM = teclado.nextInt();
        System.out.println();
        
        //Arrays.fill(numeroN, numeroM);
        //for (int i = 0; i < numeroN.length; i++) {
          //  System.out.print(numeroN[i]+",");   
        //}
        
        for (int i = 0; i < numeroN.length; i++) {
            numeroN[i]=numeroM;
            System.out.println(numeroN[i]);
        }
        teclado.close();
    }
}