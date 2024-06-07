package ies.thiar.pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EjerLa {
    public static void main(String[] args) {
        ArrayList<String>lista = new ArrayList<>();
        lista.add("null");
        lista.add("se");
        lista.add("bbbb");
        lista.add("afnja");
        lista.add("njsjg");
        lista.add("bjnasf");
        lista.add("iorgr");
        lista.add("anas");

        Collections.sort(lista,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            } 
        });
        lista.stream().forEach(System.out::println);
    }
}
