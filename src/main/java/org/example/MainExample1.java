package org.example;

import java.util.*;

interface DBConnector{

    public int getSalary();

}

class Oracle implements DBConnector{

    @Override
    public int getSalary() {
        return 1;
    }
}

class PostGre implements DBConnector{

    @Override
    public int getSalary() {
        return 2;
    }
}

public class MainExample1 {

    public static void main(String[] args){

        Comparator<Integer> ascending = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return 1;
                if (o1 == o2)
                    return 0;
                return -1;
            }
        };

        Queue<Integer> pq=
                new PriorityQueue<Integer>(10,ascending);
        pq.offer(1);
        pq.offer(100);
        pq.offer(10);

        for (Integer integer : pq){
            System.out.println(integer);
        }

        System.out.println("++++++++++++++++++");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

    }

    public static int getMeSalary(DBConnector dbConnector){
        return dbConnector.getSalary();
    }

    public static void allEven6DigitPalindromes(int n){

        int i = 2;
        int j = 0;
        int k = 0;

        String tempString = "";
        while (i < 10){
            tempString = "";
            tempString += "" + i;
            while (j < 10){
                tempString += j;
                while (k < 10){
                    tempString += k + "" + k;
                }
                tempString += j;
            }
            tempString += "" + i;
        }

        System.out.println(tempString);

    }

    public static Map<Character, Integer> frequencies(String s){

        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0 ; i < length; i++){

            Character tempCharacter = s.charAt(i);
            Integer value = map.get(tempCharacter);
            if (value == null){
                map.put(tempCharacter, 1);
            }else {
                map.put(tempCharacter, value+1);
            }
        }
        return map;
    }
}
