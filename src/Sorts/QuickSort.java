package Sorts;

/**
 * Created by Le on 2015/11/18.
 */
public class QuickSort {
    private static void quickSort(int[] array, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        //partition
        int m = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (array[i] < array[lo]) {
                m += 1;
                swap(array, m, i);
            }
        }
        // swap between array[m] and array[l]
        // put pivot in the mid
        swap(array, m, lo);

        quickSort(array, lo, m - 1);
        quickSort(array, m + 1, hi);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int unsortedArray[] = new int[]{1, 35, 7, 4, 5, 6, 8, 0, 324, 543, 2, 12, 33, 56};
        quickSort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
    }
}
