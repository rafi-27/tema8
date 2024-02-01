package ies.thiar.Examen;
import java.util.concurrent.ThreadLocalRandom;

public class EjerArrays {
    /**
     * 
     */
    public static void main(String[] args) {
        if (args.length == 2 && args[0].matches("\\d*") && args[1].matches("\\d*")) {
            int[][] matriz = new int[Integer.parseInt(args[0])][Integer.parseInt(args[1])];

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 101);
                }
            }
            mostrarMaximoMatriz(matriz);
        }else{
            System.err.println("Error al introducir la longitud de la matriz.");
        }
    }

    public static void mostrarMaximoMatriz(int[][] matriz) {
        // Usaremos los metodos que nos da la clase Collections.
        int mayorFila=-999999;
        int mayorColum=-99999;
        for (int i = 0; i < matriz.length; i++) {
            mayorFila=-999999;
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j]>mayorFila) {
                    mayorFila = matriz[i][j];
                }
                System.out.printf("%4d", matriz[i][j]);
                if (matriz[j][i]>mayorColum) {
                    mayorColum = matriz[j][i];
                }
            }
            System.out.println(" "+"[" +mayorFila+"]");
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {
            mayorColum=-999999;
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[j][i]>mayorColum) {
                    mayorColum = matriz[j][i];
                }
            }
            System.out.print(" "+"["+mayorColum+"]");
        }
        System.out.println();
    }
}