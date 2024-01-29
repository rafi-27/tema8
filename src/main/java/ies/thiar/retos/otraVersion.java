package ies.thiar.retos;
import java.util.concurrent.ThreadLocalRandom;
public class otraVersion {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Se requieren tres argumentos: alto, ancho y cantidad de minas.");
            return;
        }

        int alto = Integer.parseInt(args[0]);
        int ancho = Integer.parseInt(args[1]);
        int cantidadMinas = Integer.parseInt(args[2]);

        if (alto <= 0 || ancho <= 0) {
            System.err.println("Error: El alto y el ancho deben ser enteros positivos.");
            return;
        }

        if (cantidadMinas < 0 || cantidadMinas > alto * ancho) {
            System.err.println("Error: La cantidad de minas debe ser un número positivo menor o igual al tamaño del tablero.");
            return;
        }

        otraVersion buscaMinas = new otraVersion();
        int[][] tablero = buscaMinas.crearTablero(alto, ancho, cantidadMinas);
        buscaMinas.tirada(tablero, 2, 2);
        buscaMinas.tirada(tablero, 2, 1);
        buscaMinas.tirada(tablero, 2, 0);
        buscaMinas.tirada(tablero, 0, 0);
        buscaMinas.tirada(tablero, 0, 1);
        buscaMinas.mostrarMatriz(tablero, true);
        System.out.println("Diference");
        buscaMinas.mostrarMatriz(tablero, false);
        System.out.println("otra");
        int[][] otroTablero = buscaMinas.crearTablero(alto, ancho, cantidadMinas);
        buscaMinas.rellenarMatriz(otroTablero);
    }

    private int[][] crearTablero(int alto, int ancho, int cantidadMinas) {
        int[][] matriz = new int[alto][ancho];

        while (cantidadMinas > 0) {
            int x = ThreadLocalRandom.current().nextInt(0, alto);
            int y = ThreadLocalRandom.current().nextInt(0, ancho);
            if (matriz[x][y] != -1) {
                matriz[x][y] = -1;
                cantidadMinas--;
            }
        }

        return matriz;
    }

    private boolean tirada(int[][] matriz, int fila, int columna) {
        if (matriz[fila][columna] == -1) {
            return true;
        }
        matriz[fila][columna] = -2;
        return false;
    }

    private void mostrarMatriz(int[][] matriz, boolean completo) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (completo || valor == -2) {
                    System.out.printf("%4d", valor);
                } else {
                    System.out.print((valor == 0 || valor == -1) ? " " : "X");
                }
            }
            System.out.println();
        }
    }

    private void rellenarMatriz(int[][] matriz) {
        int alto = matriz.length;
        int ancho = matriz[0].length;

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (matriz[i][j] == 0) {
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < alto && y >= 0 && y < ancho && matriz[x][y] == -1) {
                                matriz[i][j]++;
                            }
                        }
                    }
                }
            }
        }

        mostrarMatriz(matriz, true);
    }
}