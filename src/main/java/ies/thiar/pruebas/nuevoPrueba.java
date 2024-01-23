package ies.thiar.pruebas;
import java.util.concurrent.ThreadLocalRandom;
public class nuevoPrueba {
    private static int[][] generarTablero() {
        int[][] matriz = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
            }
        }
        return matriz;
    }

    private static void mostrarTablero(int[][] tablero) {
        System.out.println("Tablero:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int contarLineas(int[][] tablero, int jugador) {
        int lineas = 0;

        for (int[] ints : tablero) {
            if (ints[0] == jugador && ints[1] == jugador && ints[2] == jugador) lineas++;
        }

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) lineas++;
        }

        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) lineas++;


        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) lineas++;


        return lineas;
    }

    public static void main(String[] args) {
        int[][] tablero = generarTablero();
        mostrarTablero(tablero);

        int lineasCero = contarLineas(tablero, 0);
        int lineasUno = contarLineas(tablero, 1);

        System.out.println("Líneas del jugador 0: " + lineasCero);
        System.out.println("Líneas del jugador 1: " + lineasUno);

        if (lineasCero > lineasUno) System.out.println("Ganador Jugador 0");
        else if (lineasCero < lineasUno) System.out.println("Ganador Jugador 1");
        else System.out.println("Empate");
    }
    
}