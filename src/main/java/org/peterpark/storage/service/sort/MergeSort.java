package org.peterpark.storage.service.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: peter
 * @date: 2019/2/2.
 */
public class MergeSort {
    private void sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, 0, a, low, temp.length);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] input = new int[]{3, 9, 89, 33, 12, 76, 99, 67};
        mergeSort.sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
