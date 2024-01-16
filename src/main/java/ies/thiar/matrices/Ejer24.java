package ies.thiar.matrices;

import java.util.Scanner;

public class Ejer24 {
    public static void main(String[] args) {
     /**
      * Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados
      * “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por
      * teclado y luego el programa mostrará la nota mínima, máxima y media de cada alumno.
      * for(int[] elemento: sueldos) 
      * for(int entero: elemento) 
      */
      Scanner teclado = new Scanner(System.in);
      float[][] alumnos = new float[4][5];
        float minima = 9999999;
        float maxima = -9999999;
        float media=0;

      for (int i = 0; i < alumnos.length; i++) {
        System.out.println("Alumno "+i);
        for (int j = 0; j < alumnos[0].length; j++) {
            System.out.println("Introduce nota: ");
            float nota = teclado.nextFloat();
            alumnos[i][j]=nota;
            media+=nota;
            if (nota > maxima) {
                maxima=nota;
            }
            if (nota<minima) {
                minima=nota;
            }
            int cont=1;
            if (j == alumnos[0].length-1) {
                media/=5;
                for (int k = 0; k < 1; k++) {
                    System.out.println("Alumno "+cont+" tiene de nota maxima un "+maxima+", minima "+minima+" y una media de "+media);
                }
                minima = 9999999;
                maxima = -9999999;
                media=0;      
            }
            cont++;
        }
        System.out.println();
    }
      teclado.close();
}
}