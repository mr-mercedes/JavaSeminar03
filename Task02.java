package ru.Seminar03;

/*
    2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = fillArrayList();

        int minNumberOfArrayList = getMinNumberOfArrayList(arrayList);
        int maxNumberOfArrayList = getMaxNumberOfArrayList(arrayList);
        int averageNumberOfArrayList = getAverageNumberOfArrayList(arrayList);

        System.out.println("Start arraylist ->" + arrayList + "<-");
        System.out.printf("Min number = %d, Max number = %d, Average number = %d\n", minNumberOfArrayList,
                                                                        maxNumberOfArrayList, averageNumberOfArrayList);
    }

    private static int getAverageNumberOfArrayList(ArrayList<Integer> arrayList) {
        ArrayList<Integer> tmpList = new ArrayList<>();
        int sumArray = getSumArrayList(arrayList);
        int tmp = sumArray / arrayList.size();
        int average = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (tmp == arrayList.get(i)) {
                average = tmp;
                return average;
            } else {
                average = getAverageNUmber(tmp, arrayList.get(i), arrayList, tmpList);
            }
        }
        return average;
    }

    private static int getAverageNUmber(int average, Integer number, ArrayList<Integer> arrayList, ArrayList<Integer> tmpList) {
        int index = 0;
        tmpList.add(Math.abs(number - average));
        if (tmpList.size() == arrayList.size()) {
            index = getIndexOfAverageNumber(tmpList);
        }
        return arrayList.get(index);
    }

    private static int getIndexOfAverageNumber(ArrayList<Integer> arrayList) {
        int min = arrayList.get(0);
        int index = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < min) {
                min = arrayList.get(i);
                index = i;
            }
        }
        return index;
    }

    private static int getSumArrayList(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        return sum;
    }

    private static int getMaxNumberOfArrayList(ArrayList<Integer> arrayList) {
        int max = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        return max;
    }

    private static int getMinNumberOfArrayList(ArrayList<Integer> arrayList) {
        int min = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < min) {
                min = arrayList.get(i);
            }
        }
        return min;
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
