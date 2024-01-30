package ies.thiar.retos;
import java.util.ArrayList;
public class ejr {
    public static void main(String[] args) {
        // Supongamos que tenemos una matriz de enteros
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Creamos un ArrayList para almacenar los arreglos de la matriz
        ArrayList<int[]> arrayList = new ArrayList<>();

        // Recorremos la matriz y agregamos cada fila al ArrayList
        for (int i = 0; i < matriz.length; i++) {
            arrayList.add(matriz[i]);
        }

        // Imprimimos el ArrayList para verificar
        for (int[] array : arrayList) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
