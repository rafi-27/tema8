package ies.thiar.matrices;

public class Ejer22 {
    public static void main(String[] args) {
        /**
         * Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas
         * de multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por
         * pantalla.
         */
         int[][] matriz = new int[11][11];
        int result=0;
        int cont=1;
        for (int i = 1; i < matriz[0].length; i++) {
            System.out.println("Tabla multiplicar del: "+i);
            for (int j = 1; j < matriz.length; j++) {
                matriz[i][j]=i;
                //result=matriz[i][j]*matriz[i][j];
                result=matriz[i][j]*cont;
                System.out.println(matriz[i][j]+"x"+cont+": "+result);
                cont++;
                if (cont == 11) {
                    cont=1;
                }
            }
            System.out.println();
        }
    }
}