package ies.thiar.matrices;

import java.util.Scanner;

public class Ejer241 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Creamos el array:
        double[][] alumnos = new double[4][5];
        double maxima;
        double minima;
        double media;

        int cont=1;
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i][0]=cont;
            cont++;
        }
        cont=1;
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Alumno: "+cont);
            for (int j = 0; j < alumnos[0].length; j++) {
                System.out.println("Nota numero: "+cont);
                double nota = teclado.nextDouble();
                alumnos[i][j]=nota;
            }
            cont++;
        }

        cont=1;
        for (int i = 0; i < alumnos.length; i++) {
            maxima = -99999;
            minima = 99999;
            media=0;
            for (int j = 0; j < alumnos[0].length; j++) {
               
                media+=alumnos[i][j];
                
               if (alumnos[i][j]<minima) {
                minima=alumnos[i][j];
               }
               
               if (alumnos[i][j]>maxima) {
                maxima=alumnos[i][j];
               }
            }
            System.out.println("Alumno "+cont);            
            System.out.println("Nota maxima --> "+maxima);
            System.out.println("Nota minima --> "+minima);
            System.out.println("Media --> "+(media/5));
            cont++;
            System.out.println();
        }
        teclado.close();
    }
}