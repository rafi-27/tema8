package ies.thiar.pruebas;
import java.util.concurrent.ThreadLocalRandom;
public class ejer55 {
    public static void main(String[] args) {
        int[][] tresEnRaya = new int[3][3];

        // Inicializar el tablero
        for (int i = 0; i < tresEnRaya.length; i++) {
            for (int j = 0; j < tresEnRaya[0].length; j++) {
                tresEnRaya[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
            }
        }

        // Contadores
        int contUno = 0;
        int contCero = 0;

        // Verificar líneas por columnas y filas
        for (int i = 0; i < 3; i++) {
            if ((tresEnRaya[i][0] == 0 && tresEnRaya[i][1] == 0 && tresEnRaya[i][2] == 0) ||
                (tresEnRaya[0][i] == 0 && tresEnRaya[1][i] == 0 && tresEnRaya[2][i] == 0)) {
                contCero++;
            }

            if ((tresEnRaya[i][0] == 1 && tresEnRaya[i][1] == 1 && tresEnRaya[i][2] == 1) ||
                (tresEnRaya[0][i] == 1 && tresEnRaya[1][i] == 1 && tresEnRaya[2][i] == 1)) {
                contUno++;
            }
        }

        // Verificar líneas diagonales
        if ((tresEnRaya[0][0] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][2] == 0) ||
            (tresEnRaya[0][2] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][0] == 0)) {
            contCero++;
        }

        if ((tresEnRaya[0][0] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][2] == 1) ||
            (tresEnRaya[0][2] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][0] == 1)) {
            contUno++;
        }

        // Imprimir el tablero
        for (int i = 0; i < tresEnRaya.length; i++) {
            for (int j = 0; j < tresEnRaya.length; j++) {
                System.out.print(tresEnRaya[i][j] + " ");
            }
            System.out.println();
        }

        // Mostrar resultados
        System.out.println("Lineas 0: " + contCero);
        System.out.println("Lineas 1: " + contUno);

        if (contCero > contUno) {
            System.out.println("Ha ganado el Cero con " + contCero + " movimientos correctos.");
        } else if (contUno > contCero) {
            System.out.println("Ha ganado el Uno con " + contUno + " movimientos correctos.");
        } else {
            System.out.println("Empate!");
        }
    }
}