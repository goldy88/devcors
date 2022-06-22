package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BrnoLesson3 {

    public static void main(String[] args) {

        String[] myStringArray = new String[5]; // prní způsob
        myStringArray[0] = "petr";

        int[] myNumbers = {10, 20, 40,55};     // druhý způsopb

        //dvojrozměrné pole
        int[][] array = {{2,5,7},{4,8,10}};

        System.out.println(array.length);

        List<String> myList = new ArrayList<>();
        myList.add("pavel");
        myList.add("jiří");
        myList.add("karel");

        //  výpis listu
        for (String str : myList){
            System.out.println(str);
        }

        // výpis podle indexu
        System.out.println(myList.get(1));

        // mapa
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, " jedna");
        myMap.put(2, " dva");
        System.out.println(myMap.get(2));


        List<Integer> mylist = List.of(1,2,3,4,5);
        List<Integer> integers = mylist.stream().filter(myNumber -> myNumber>2).collect(Collectors.toList());
        System.out.println(integers);









    }
}
