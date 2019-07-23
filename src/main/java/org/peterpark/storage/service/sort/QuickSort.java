package org.peterpark.storage.service.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: peter
 * @date: 2019/2/2.
 */
public class QuickSort {

    private void doSort(int[] arr, int start, int end) throws Exception {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        doSort(arr, pivot + 1, end);
        doSort(arr, start, pivot - 1);
    }

    private int partition(int[] input, int left, int right) {
        int pivot = input[left], j = left;
        while (left < right) {
            while (left < right && input[right] >= pivot) {
                right--;
            }
            while (left < right && input[left] <= pivot) {
                left++;
            }
            swap(input, left, right);
        }
        swap(input, right, j);
        return right;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        QuickSort quickSort = new QuickSort();
        int[] input = new int[]{3, 9, 89, 33, 12, 76, 99, 67};
        quickSort.doSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
