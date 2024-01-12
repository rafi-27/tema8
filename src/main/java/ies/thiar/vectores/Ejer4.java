package ies.thiar.vectores;

import java.util.Scanner;

public class Ejer4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * 4. Crea un programa que pida veinte números enteros por teclado, 
         * los almacene en un array y 
         * luego muestre por separado la suma de todos los valores positivos y negativos.
         */

        //creamos la variable de array que va almacenar los 20 numeros.
        int[] numeros = new int[20];

         int sumaPos = 0;
         int sumaNega = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Indice: "+i);
            numeros[i] = teclado.nextInt();

            if (numeros[i]>=0) {
                sumaPos+=numeros[i];
            }else{
                sumaNega+=numeros[i];
            }
         }
         System.out.println("La suma de los positivos es de: "+sumaPos);
         System.out.println("La suma de los negativos es: "+sumaNega);
         teclado.close();
    }
}
