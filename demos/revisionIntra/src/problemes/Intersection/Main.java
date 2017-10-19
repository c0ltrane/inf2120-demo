package problemes.Intersection;

import problemes.Timer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by thomas on 10/19/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1,2,3,5,8,13,21,1,2,3,5,8,13,211,2,3,5,8,13,211,2,3,5,8,13,211,2,3,5,8,13,21));
        ArrayList<Integer> anotherList = new ArrayList<>(Arrays.asList(2,2,5,9,13,22,55,12,9,6,4,7,14,5,4,6,9,8,0,1,22,6,47,42));
        ArrayList<Integer> intersection;


        Timer timer = new Timer();
        intersection = calculIntersection(aList, anotherList);
        long elapsedTime = timer.getElapsedTime();
        System.out.println(intersection + " time: " + elapsedTime);


        timer.restart();
        intersection = calculIntersectionPerformant(aList, anotherList);
        elapsedTime = timer.getElapsedTime();


        System.out.println(intersection + " time: " + elapsedTime);
    }

    public static ArrayList<Integer> calculIntersection(ArrayList<Integer> p, ArrayList<Integer> k){
        ArrayList<Integer> intersection = new ArrayList<>();

        for (Integer i: p) {
            for (Integer j: k) {
               if(i == j && !intersection.contains(i))
                   intersection.add(i);
            }
        }

        return intersection;
    }

    public static ArrayList<Integer> calculIntersectionPerformant(ArrayList<Integer> p, ArrayList<Integer> k){
        int taille = Math.max(findMax(p), findMax(k));
        boolean[] hashTable = new boolean[taille + 1];

        ArrayList<Integer> intersection = new ArrayList<>();

        for (Integer i: p) {
          hashTable[i] = true;
        }

        for(Integer j: k){
            if(hashTable[j]){
                intersection.add(j);
                hashTable[j] = false;
            }
        }

        return intersection;
    }

    private static int findMax(ArrayList<Integer> arr){
        int max = Integer.MIN_VALUE;
        for(Integer i: arr){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
