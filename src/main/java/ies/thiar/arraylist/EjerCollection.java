package ies.thiar.arraylist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class EjerCollection {
    /**
     * Realizar un programa que cree un ArrayList con 10.000 números aleatorios entre 1 y 6
     * Utilizando los métodos estáticos de la clase Collections guarda en otro ArrayList la distribución de resultados obtenidos 
     * (cuantas veces ha salido el uno, cuantas veces ha salido el dos, etc…) y muestra su contenido. Finalmente,
     * también mediante métodos de Collections, mostrar la diferencia de veces entre el
     * número que más ha salido y el que menos ha salido.
     */
     public static void main(String[] args) {
        ArrayList<Integer>numeros = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numeros.add(ThreadLocalRandom.current().nextInt(1,7));
        }
        ArrayList<Integer>numerosDos = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numerosDos.add(Collections.frequency(numeros,i));
        }
        System.out.println(numerosDos.toString());
        System.out.println("El que mas aparece es: "+(numerosDos.indexOf(Collections.max(numerosDos))+1));
        System.out.println("El que menos aparece es: "+(numerosDos.indexOf(Collections.min(numerosDos))+1));
        System.out.println();
        int number = Collections.max(numerosDos);
        int numberSecond = Collections.min(numerosDos);
        System.out.println("Hay una diferencia de veces entre ellos de "+(number-numberSecond));
    }
}