package ies.thiar.retos;
import java.util.concurrent.ThreadLocalRandom;

public class probamosBucle {
    //private int[][] tableroPrincipal;
    public static void main(String[] args) {
        probamosBucle tablero = new probamosBucle();
        int[][] mesaUno = new int[5][5];
        for (int i = 0; i < mesaUno.length; i++) {
            for (int j = 0; j < mesaUno[0].length; j++) {
                mesaUno[i][j]= ThreadLocalRandom.current().nextInt(-2,2);
            }
        }

        tablero.mostrarMatriz(mesaUno);
    }
    private void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor); // Utilizamos un ancho de campo de 4 caracteres para los números
            }
            System.out.println();
        }
    }
}
