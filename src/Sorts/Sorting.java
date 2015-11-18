package Sorts;

/**
 * Created by Le on 2015/11/17.
 */
public class Sorting {
    public static int[] bubbleSort(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
        return A;
    }

    public static int[] selectionSort(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                min = A[min] > A[j] ? j : min;
            }
            swap(A, i, min);
        }

        return A;
    }

    public static int[] insertionSort(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0 && (A[j] < A[j - 1]); j--) {
                swap(A, j, j - 1);
            }
        }
        return A;
    }

    public static int[] shellSort(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int N = A.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            //insertionSort but with range h
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && (A[j] < A[j - h]); j = j - h) {
                    swap(A, j, j - h);
                }
            }
            h = h / 3;
        }
        return A;
    }


    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
