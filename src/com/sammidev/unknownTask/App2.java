package com.sammidev.unknownTask;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        Integer[] case1 = {-1,0,1,2,3,4,6,7,8,9,10,11};
        Integer[] case2 = {-8,-2,0,3,9};
        Integer[] case3 = {4,7,9,12,14,19};
        Integer[] case4 = {-2,1,3,5};
        System.out.println(task1(case1, 0, (case1.length-1))); // true
        System.out.println(task1(case2, 0, (case2.length-1))); // true
        System.out.println(task1(case3, 0, (case3.length-1))); // false
        System.out.println(task1(case4, 0, (case4.length-1))); // true

        Integer[] case5 = {1,2,3,4,5};
        Integer[] case6 = {3,1,2,5,4,7};
        task2(case5.length, case5); // 51423
        task2(case6.length, case6); // 715243
    }

    static boolean task1(Integer[] arr, int low, int high) {
          if (high >= low) {
              int mid = (low + high) / 2;
              if (mid == arr[mid]) {
                  return true;
              }
              if (mid > arr[mid]) {
                  return task1(arr, (mid + 1), high);
              }else {
                  return task1(arr, low, (mid - 1));
              }
          }
        return false;
    }
    static void task2(int length, Integer[] arr) {
        List<Integer> integerList = new ArrayList<>();
        Integer[] sortingArray = sorting(arr);
        Integer[] result = new Integer[length];

        for (int i = 0; i < arr.length; i++) {
            int temp = sortingArray[i];
            result[i] = sortingArray[sortingArray.length -1 - i];
            result[sortingArray.length - 1 - i] = temp;
        }
        Integer[] tempasc = new Integer[result.length / 2];
        Integer[] tempdesc = new Integer[result.length / 2];
        Integer[] tempdescOdd = new Integer[(result.length / 2) +1];
        if (result.length % 2 == 0) {
            for (int i = 0; i < result.length / 2; i++) {
                tempasc[i] = sortingArray[i];
                tempdesc[i] = result[i];
            }
            for (int i = 0; i < tempasc.length; i++) {
                integerList.add(tempdesc[i]);
                integerList.add(tempasc[i]);
            }
        }else {
            if (result.length / 2 >= 0) System.arraycopy(sortingArray, 0, tempasc, 0, result.length / 2);
            if ((result.length / 2) + 1 >= 0) System.arraycopy(result, 0, tempdescOdd, 0, (result.length / 2) + 1);
            for (int i = 0; i < tempasc.length; i++) {
                integerList.add(tempdescOdd[i]);
                integerList.add(tempasc[i]);
            }
            integerList.add((result.length / 2) + 1);
        }
        System.out.println(integerList);
    }

    static Integer[] sorting(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > element) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = element;
        }
        return arr;
    }
}