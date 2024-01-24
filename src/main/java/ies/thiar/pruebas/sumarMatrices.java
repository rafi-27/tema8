package ies.thiar.pruebas;

public class sumarMatrices {
    public static void main(String[] args) {
        //Vamos a sumar dos matrizes:

        int[][] primeraMatriz = new int[2][3];
        int[][] segundaMatriz = new int[2][3];
        /**Matriz A    2   1   3          Matriz B     1   5   2
                       4   0   8                       3   1   7
        La matriz C, suma de A + B será esta:
        Matriz C     3   6   5
                     7   1  15  
        */
        primeraMatriz[0][0]=2;
        primeraMatriz[0][1]=1;
        primeraMatriz[0][2]=3;
        primeraMatriz[1][0]=4;
        primeraMatriz[1][1]=0;
        primeraMatriz[1][2]=8;
        //--------------------
        segundaMatriz[0][0]=1;
        segundaMatriz[0][1]=5;
        segundaMatriz[0][2]=2;
        segundaMatriz[1][0]=3;
        segundaMatriz[1][1]=1;
        segundaMatriz[1][2]=7;

        //Esta sera la matriz que contendra la suma: 
        int[][] terceraMatriz = new int[2][3];
        for (int i = 0; i < terceraMatriz.length; i++) {
            for (int j = 0; j < terceraMatriz[0].length; j++) {
                terceraMatriz[i][j]=primeraMatriz[i][j]+segundaMatriz[i][j];
            }
        }

        for (int i = 0; i < terceraMatriz.length; i++) {
            for (int j = 0; j < terceraMatriz[0].length; j++) {
                System.out.print(terceraMatriz[i][j]+" ");
            }
            System.out.println();
        }











    }
}