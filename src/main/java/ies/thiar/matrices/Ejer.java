package ies.thiar.matrices;

import java.util.Scanner;

public class Ejer {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float[][] alumnos = new float[2][3];
        
        for (int i = 0; i < alumnos.length; i++) {
            float minima = 9999999;
            float maxima = -9999999;
            float media = 0;

            System.out.println("Alumno " + i);
            for (int j = 0; j < alumnos[0].length; j++) {
                System.out.println("Introduce nota: ");
                float nota = teclado.nextFloat();
                alumnos[0][j] = nota;
                media += nota;
                if (nota > maxima) {
                    maxima = nota;
                }
                if (nota < minima) {
                    minima = nota;
                }
            }
            media /= alumnos[i].length;
            System.out.println("Alumno "+i+" tiene de nota maxima un " + maxima + ", minima "+ minima + " y una media de " + media);
        }
     teclado.close();   
    }
}