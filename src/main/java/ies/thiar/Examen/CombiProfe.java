package ies.thiar.Examen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class CombiProfe {
    public static void main(String[] args) {
        conbiMil();
    }


    public static int[] conbiMil(){
        //Del 1 al 49
        int[] vector = new int[49];
        for (int i = 0; i < 5000000; i++) {
            int numeroAleatorio = ThreadLocalRandom.current().nextInt(1,50);
            vector[numeroAleatorio-1]++;
        }
        //En otro vector guardare los 6 mas repetidos:
        //Lista:
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < vector.length; i++) {
            lista.add(vector[i]);
        }

        //Ordeno la lista
        Collections.sort(lista,Collections.reverseOrder());

        int[] vecesSalidonumeroGanador = new int[6];
        int[] posicionNumeroGanador = new int[6];

        for (int i = 0; i < posicionNumeroGanador.length; i++) {
            posicionNumeroGanador[i]=lista.indexOf(i);
        }

        for (int i = 0; i < vecesSalidonumeroGanador.length; i++) {
            int maximoNene = Collections.max(lista);
            vecesSalidonumeroGanador[i]=maximoNene;
            // int comoFuncioneMeRapo = lista.indexOf(maximoNene);
            // posicionNumeroGanador[i]=comoFuncioneMeRapo;
            lista.remove(lista.indexOf(maximoNene));
        }

        for (int i = 0; i < vecesSalidonumeroGanador.length; i++) {
            System.out.println("El numero: "+posicionNumeroGanador[i]+" ha salido "+vecesSalidonumeroGanador[i]+" veces.");
        }
        return vecesSalidonumeroGanador;
    }
}
