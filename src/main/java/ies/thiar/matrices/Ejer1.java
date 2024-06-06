package ies.thiar.matrices;

import java.util.concurrent.ThreadLocalRandom;

public class Ejer1 {

    public static void main(String[] args) {
        Ejer1 n = new Ejer1();
        int[][] matriz = n.crearTablero(4, 4, 2);


        //n.rellenarMatriz(matriz);
        n.mostrarMatriz(matriz, false);
    }

    int[][] crearTablero(int ancho, int alto, int minas) {
        int[][] tablero = new int[ancho][alto];
        int i=0;
        while (i<minas) {
            int uno = ThreadLocalRandom.current().nextInt(ancho);
            int dos = ThreadLocalRandom.current().nextInt(alto);
            tablero[uno][dos]=-1;
            i++;
        }
        return tablero;
    }

    boolean tirada(int[][] matriz, int n1, int n2) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    matriz[i][j] = -2;
                    return true;

                }
                if (matriz[i][j] == -1) {
                    return false;
                }
            }
        }
        return false;
    }
    // Crea una función de nombre mostrarMatriz a la que se le pasa una matriz de
    // números enteros y un valor booleano. Según el valor del parámetro booleano
    // mostrará la matriz completa o mostrará si es 0 o -1 un espacio en blanco y si
    // es un -2 mostrará una X. Haz que la matriz se vea de forma correcta en
    // formato filas y columnas.

    void mostrarMatriz(int[][] matriz, boolean bool) {
        if (bool) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.printf("%3d", matriz[i][j]);
                }
                System.out.println();
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0 || matriz[i][j] == -1) {
                    System.out.printf("%3s", " ");
                }
                if (matriz[i][j] == -2) {
                    System.out.printf("%3d", "X");
                }
            }
            System.out.println();
        }
    }

    // Crea una función de nombre rellenarMatriz a la que se le pasa una matriz de
    // números enteros y recorrerá la matriz y en las casillas que tengan un 0,
    // modificará su valor con el número de casillas adyacentes que contienen una
    // mina (es decir, que están a su lado o en diagonal y que su valor es -1)

    void rellenarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int cont = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Fila de arriba
                if (i > 0) {
                    if (matriz[i][j] == 0) {
                        if (matriz[i - 1][j] == -1) {
                            cont++;
                        }
                    }
                }
                // Fila de abajo
                if (i < filas - 1) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }
                // Izquierda
                if (j > 0) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }
                // Derecha
                if (j > columnas - 1) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }

                if (i > 0 && j > 0) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }

                // Revisar posición diagonal superior derecha
                if (i > 0 && j < columnas - 1) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }

                // Revisar posición diagonal inferior izquierda
                if (i < filas - 1 && j > 0) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }

                // Revisar posición diagonal inferior derecha
                if (i < filas - 1 && j < columnas - 1) {
                    if (matriz[i][j] == -1) {
                        cont++;
                    }
                }
                if (matriz[i][j]==0) {
                    matriz[i][j]=cont;
                }
            }
        }
    }

}
