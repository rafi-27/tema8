package ies.thiar.retos;

import java.util.concurrent.ThreadLocalRandom;

public class primerReto {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Necesitas tres argumentos: alto, ancho y cantidad de minas.");
            return;
        }
        int alto = Integer.parseInt(args[0]);
        int ancho = Integer.parseInt(args[1]);
        int cantidadMinas = Integer.parseInt(args[2]);
        primerReto buscaMinas = new primerReto();

        // crear tablero
        int[][] tablero = buscaMinas.crearTablero(alto, ancho, cantidadMinas);
        // Hacemos tiradas que nos devuelve si en la posicion -1 o -2 si es cero.
        System.out.println("Hacemos tiradas que nos devuelve si en la posicion -1 o -2 si es cero");
        buscaMinas.tirada(tablero, 2, 2);
        buscaMinas.tirada(tablero, 2, 1);
        buscaMinas.tirada(tablero, 2, 0);
        buscaMinas.tirada(tablero, 0, 0);
        buscaMinas.tirada(tablero, 0, 1);
        // Mostramos tablero si el completo es true, mostrará la matriz completa y si es
        // false si es 0 o -1 un espacio en blanco y si es un -2 mostrará una X.
        buscaMinas.mostrarMatriz(tablero, true);
        System.out.println(
                "Mostramos tablero si el completo es true,  mostrará la matriz completa y si es false si es 0 o -1 un espacio en blanco y si es un -2 mostrará una X.");
        buscaMinas.mostrarMatriz(tablero, false);
        // Otro tablero sin modificaciones solo mostrara los numeros de minas que hay.
        System.out.println("Otro tablero sin modificaciones solo mostrara los numeros de minas que hay.");
        int[][] otroTablero = buscaMinas.crearTablero(alto, ancho, cantidadMinas);
        buscaMinas.rellenarMatriz(otroTablero);
        buscaMinas.mostrarMatriz(otroTablero, true);
    }

    /**
     * 1. Vamos a crear un tablero para jugar al buscaminas, El tablero será una
     * matriz nxm de enteros,
     * cuyos valores serán 0 o -1 si tiene o no tiene una mina.
     * Crea una función de nombre crearTablero que se le pasan 3 números positivos,
     * los dos primeros corresponden al tamaño de una matriz, el tercer parámetro
     * corresponde al número de minas a poner en el tablero.
     * La función devuelve la matriz de enteros creada.
     */

    private int[][] crearTablero(int alto, int ancho, int cantidadMinas) {
        if (alto < 0 || ancho < 0) {
            System.err.println("Error alto o ancho incorrecto.");
        }
        if (cantidadMinas < 0) {
            System.err.println("cantidad incorrecta de minas.");
        }
        // Crea una matriz de alto por ancho y.
        int[][] matriz = new int[alto][ancho];
        // ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arrayNormal));
        // coloca aleatoriamente el numero de minas una mina se representa con un -1 las
        // demas 0
        int num = 0;
        while (num < cantidadMinas) {
            int x = ThreadLocalRandom.current().nextInt(0, alto);
            int y = ThreadLocalRandom.current().nextInt(0, ancho);
            if (matriz[x][y] == 0) {
                matriz[x][y] = -1;
                cantidadMinas--;
            }
        }
        return matriz;
    }

    /**
     * Crea una función tirada que tiene como parámetro una matriz de números
     * enteros y 2 números enteros.
     * Devuelve verdadero si en la posición de la matriz hay un -1 o falso si hay un
     * 0.
     * Si hay un 0 cambiará su valor por un -2.
     */

    private boolean tirada(int[][] matriz, int primerNum, int segundoNum) {
        if (matriz[primerNum][segundoNum] == -1) {
            return true;
        }
        matriz[primerNum][segundoNum] = -2;
        return false;
    }

    /**
     * Crea una función de nombre mostrarMatriz a la que se le pasa una matriz de
     * números enteros y un valor booleano.
     * Según el valor del parámetro booleano mostrará la matriz completa o mostrará
     * si es 0 o -1 un espacio en blanco
     * y si es un -2 mostrará una X.
     * Haz que la matriz se vea de forma correcta en formato filas y columnas.
     */
    private void mostrarMatriz(int[][] matriz, boolean completo) {
        if (completo) {
            for (int[] fila : matriz) {
                for (int valor : fila) {
                    System.out.printf("%4d", valor);
                }
                System.out.println();
            }
        } else {
            for (int[] fila : matriz) {
                for (int valor : fila) {
                    if (valor == 0 || valor == -1) {
                        System.out.printf("%3s ", " "); // Espacio en blanco
                    } else if (valor == -2) {
                        System.out.printf("%3s ", "X"); // Valor -1 es "X"
                    } else {
                        System.out.printf("%3d ", valor); // Otros valores numéricos
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Crea una función de nombre rellenarMatriz a la que se le pasa una matriz de
     * números enteros y recorrerá la matriz y
     * en las casillas que tengan un 0, modificará su valor con el número de
     * casillas adyacentes que contienen una mina
     * (es decir, que están a su lado o en diagonal y que su valor es -1)
     */

    /**
     * "Encima: " + matriz[fila - 1][columna]
     * "Abajo: " + matriz[fila + 1][columna]
     * "Izquierda: " + matriz[fila][columna - 1]
     * "Derecha: " + matriz[fila][columna + 1]
     * 
     * if (matriz[i -1][j] == -1) {
     * matriz[i][j] += 1;
     * }
     * if (matriz[i + 1][j] == -1) {
     * matriz[i][j] += 1;
     * }
     * if (matriz[i][j - 1] == -1) {
     * matriz[i][j] += 1;
     * }
     * if (matriz[i][j + 1] == -1) {
     * matriz[i][j] += 1;
     * }
     * i-1, j-1
     * i-1,j
     * i-1,j+1
     */
    /**
     * 0,0 0,1 0,2
     * i,j i,j i,j
     * 1,0 1,1 1,2
     * i,j i,j i,j
     * 2,0 2,1 2,2
     * i,j i,j i,j
     * 
     * @param matriz
     *               if(fila!=0){
     * 
     *               }
     */

    private void rellenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != -1) {
                    int cont = 0;

                    // Arriba
                    if (i - 1 >= 0 && matriz[i - 1][j] == -1) {
                        cont++;
                    }
                    // Abajo
                    if (i + 1 < matriz.length && matriz[i + 1][j] == -1) {
                        cont++;
                    }
                    // Izquierda
                    if (j - 1 >= 0 && matriz[i][j - 1] == -1) {
                        cont++;
                    }
                    // Derecha
                    if (j + 1 < matriz[0].length && matriz[i][j + 1] == -1) {
                        cont++;
                    }
                    // Diagonal superior izquierda
                    if (i - 1 >= 0 && j - 1 >= 0 && matriz[i - 1][j - 1] == -1) {
                        cont++;
                    }
                    // Diagonal superior derecha
                    if (i - 1 >= 0 && j + 1 < matriz[0].length && matriz[i - 1][j + 1] == -1) {
                        cont++;
                    }
                    // Diagonal inferior izquierda
                    if (i + 1 < matriz.length && j - 1 >= 0 && matriz[i + 1][j - 1] == -1) {
                        cont++;
                    }
                    // Diagonal inferior derecha
                    if (i + 1 < matriz.length && j + 1 < matriz[0].length && matriz[i + 1][j + 1] == -1) {
                        cont++;
                    }
                    matriz[i][j] = cont;
                }
            }
        }
    }
}