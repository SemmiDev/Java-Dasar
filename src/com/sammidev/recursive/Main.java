package com.sammidev.recursive;

public class Main {
    public static void main(String[] args) {

    }
    static int binnarySearch(Integer[] arr, int elem, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (elem == arr[mid]) {
                return mid;
            } else if (elem < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
