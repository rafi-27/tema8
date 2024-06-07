package ies.thiar.pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EjerLa {
    public static void main(String[] args) {
        // ArrayList<String>lista = new ArrayList<>();
        // lista.add("null");
        // lista.add("se");
        // lista.add("bbbb");
        // lista.add("afnja");
        // lista.add("njsjg");
        // lista.add("bjnasf");
        // lista.add("iorgr");
        // lista.add("anas");

        // Collections.sort(lista,new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o1.compareToIgnoreCase(o2);
        //     } 
        // });
        // lista.stream().forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 2);
        map.put("apple", 4);
        map.put("orange", 1);
        map.put("mango", 3);
        map.put("mengo", 5);


        Map<String, Integer> ordeMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
        ordeMap.forEach((key,value)->System.out.println(key+" "+value));
    }
}.
