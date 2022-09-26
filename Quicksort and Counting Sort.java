package code.Java;

import java.util.Random;
import java.util.Scanner;

public class Assignment_9 {
    // for partition
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // for random partition
    static void randompartition(int arr[], int low, int high) {
        Random prand = new Random();
        int pivot = prand.nextInt(high - low) + low;
        int tempot = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = tempot;
    }

    // for ramdom partition of indexs
    static int rpartition(int arr[], int low, int high) {
        randompartition(arr, low, high);
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Quicksort algorithm
    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // randomise sorting
    static void sorting(int arr[], int low, int high) {
        if (low < high) {
            int pi = rpartition(arr, low, high);
            sorting(arr, low, pi - 1);
            sorting(arr, pi + 1, high);
        }
    }

    // for printing array
    static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.print(arr[i] + "       ");
                System.out.println();
            } else {
                System.out.print(arr[i] + "            ");
            }
        }
    }

    // to generate random array
    static void randomarray(int arr[]) {
        int size = arr.length;
        Random prand = new Random();
        for (int i = 0; i < size; i++) {
            int low = 100;
            int high = 999;
            int result = prand.nextInt(high - low) + low;
            if (result != 0)
                arr[i] = result;
        }
    }

    // to reverse an array
    static void reversearray(int arr[], int size) {
        int reverse[] = new int[size];
        int j = size;
        for (int i = 0; i < size; i++) {
            reverse[j - 1] = arr[i];
            j -= 1;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = reverse[i];
        }
    }

    // counting sort algorithm
    void sortingforcounting(int arr[], int size) {
        int temp[] = new int[size + 1];
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int count[] = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }
        for (int i = 0; i < size; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            temp[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array  :   ");
        int size = sc.nextInt();
        sc.close();
        int arr[] = new int[size];
        randomarray(arr);
        Assignment_9 ob = new Assignment_9();
        System.out.println("\n\n\n\t\t\tChecking for random array Case      \n\t\t\t\t********* ");
        System.out.println();
        long start = System.nanoTime();
        sort(arr, 0, size - 1);
        long stop = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort is ");
        System.out.print(stop - start);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by Quick Sort is       :");
        print(arr);
        System.out.println();
        System.out.println();
        int arra[] = new int[size];
        randomarray(arra);
        System.out.println();
        System.out.println();
        long startj = System.nanoTime();
        sorting(arra, 0, size - 1);
        long stopj = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort by pivoting randomly is ");
        System.out.print(stopj - startj);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by using Random pivoting Quick Sort is       :");
        print(arra);
        System.out.println();
        System.out.println();
        int array[] = new int[size];
        randomarray(array);
        System.out.println();
        long startjp = System.nanoTime();
        ob.sortingforcounting(array, size);
        long stopjp = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by CountingSort is ");
        System.out.print(stopjp - startjp);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by using Counting Sort is       :");
        System.out.println();
        print(array);
        System.out.println();
        System.out.println();
        System.out.println("\t\t\tChecking for Ascending array Case      \n\t\t\t\t********* ");
        System.out.println();
        System.out.println();
        long startjpg = System.nanoTime();
        sort(arr, 0, size - 1);
        long stopjpg = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort is ");
        System.out.print(stopjpg - startjpg);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by Quick Sort is       :");
        print(arr);
        System.out.println();
        System.out.println();
        long star = System.nanoTime();
        sorting(arra, 0, size - 1);
        long sto = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort by pivoting randomly is ");
        System.out.print(sto - star);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by using Random pivoting Quick Sort is       :");
        System.out.println();
        print(arra);
        System.out.println();
        System.out.println();
        long sta = System.nanoTime();
        ob.sortingforcounting(array, size);
        long st = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort is ");
        System.out.print(st - sta);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by using Counting Sort is       :");
        System.out.println();
        print(array);
        System.out.println();
        System.out.println();
        System.out.println("\t\t\tChecking for Descending array Case      \n\t\t\t\t********* ");
        System.out.println();
        reversearray(arr, size);
        System.out.println();
        long starti = System.nanoTime();
        sort(arr, 0, size - 1);
        long end = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort is ");
        System.out.print(end - starti);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by Quick Sort is       :");
        print(arr);
        System.out.println();
        System.out.println();
        reversearray(arra, size);
        long startin = System.nanoTime();
        sorting(arra, 0, size - 1);
        long endin = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort by pivoting randomly is ");
        System.out.print(endin - startin);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by using Random pivoting Quick Sort is       :");
        System.out.println();
        print(arra);
        System.out.println();
        System.out.println();
        reversearray(array, size);
        System.out.println();
        long starting = System.nanoTime();
        ob.sortingforcounting(array, size);
        long ending = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by QuickSort is ");
        System.out.print(ending - starting);
        System.out.println();
        System.out.println();
        System.out.println("Sorted Array by using Counting Sort is       :");
        print(array);
        System.out.println();
    }
}