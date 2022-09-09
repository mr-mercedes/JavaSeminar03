package ru.Seminar03;

/*
    1. Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = fillArrayList();
        System.out.println(arrayList);

        clearArrayList(arrayList);
        System.out.println(arrayList);

    }

    private static void clearArrayList(ArrayList<Integer> arrayList) {
        int index = 0;
        while (index < arrayList.size()) {
            if (arrayList.get(index) %2 == 0) {
                arrayList.remove(index);
            } else {
                index++;
            }

        }
    }

    private static ArrayList<Integer> fillArrayList() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of list: ");
        int length = scanner.nextInt();
        ArrayList<Integer> arrayList =  new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrayList.add(rnd.nextInt(100));
        }
        return arrayList;
    }
}
