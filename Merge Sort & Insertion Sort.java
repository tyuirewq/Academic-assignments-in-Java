package code.Java;

import java.util.*;

class Assignment_8 {
    // For Insertion Sorting Method
    void sort(int array[]) {
        int ArraySIze = array.length;
        for (int initialposition = 1; initialposition < ArraySIze; ++initialposition) {
            int Main = array[initialposition];
            int j = initialposition - 1;

            while (j >= 0 && array[j] > Main) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = Main;
        }
    }

    // this for to merge the two half array made from a to b and b+1 to c
    void merge(int array[], int a, int b, int c) {
        int p1 = b - a + 1;
        int p2 = c - b;
        int A[] = new int[p1];
        int C[] = new int[p2];
        for (int i = 0; i < p1; ++i)
            A[i] = array[a + i];
        for (int j = 0; j < p2; ++j)
            C[j] = array[b + 1 + j];
        int i = 0, j = 0;
        int z = a;
        while (i < p1 && j < p2) {
            if (A[i] <= C[j]) {
                array[z] = A[i];
                i++;
            } else {
                array[z] = C[j];
                j++;
            }
            z++;
        }
        while (i < p1) {
            array[z] = A[i];
            i++;
            z++;
        }
        while (j < p2) {
            array[z] = C[j];
            j++;
            z++;
        }

    }

    // For Merge Sorting Method
    void sorting(int arr[], int a, int c) {
        if (a < c) {
            int b = a + (c - a) / 2;
            sorting(arr, a, b);
            sorting(arr, b + 1, c);
            merge(arr, a, b, c);
        }
    }

    // to show the sorted array by insertion sorted method
    static void insertion(int array[]) {
        Assignment_8 ob = new Assignment_8();
        long start = System.nanoTime();
        ob.sort(array);
        long stop = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by InsertionSort is  ");
        System.out.print(stop - start);
        System.out.println();
        System.out.println("After Sorting Array by InsertionSort Method");
        printArray(array);
        System.out.println();
        System.out.println();
    }

    // to show the sorted array by merge sorted method
    static void MergeSort(int array[]) {
        Assignment_8 obj = new Assignment_8();
        long startj = System.nanoTime();
        obj.sorting(array, 0, array.length - 1);
        long stopj = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by MergeSort is ");
        System.out.print(stopj - startj);
        System.out.println();
        System.out.println("After Sorting Array by MergeSort Method");
        printArray(array);
    }

    // to print an array
    static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + "  ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give the size of array   :   ");
        int size = sc.nextInt();
        int array[] = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int low = 1;
            int high = 500;
            int result = r.nextInt(high - low) + low;
            if (result != 0)
                array[i] = result;
        }
        System.out.println("Before Sorting Our Random Array is ");
        printArray(array);
        System.out.println();
        int temp[] = new int[size];
        for (int k = 0; k < size; k++)
            temp[k] = array[k];
        System.out.println();
        System.out.println("\t\t\tChecking for random array        \n\t\t\t\t********* ");
        MergeSort(array);
        System.out.println();
        insertion(temp);
        System.out.println();
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        System.out.println("\t\t\tChecking for ascending array        \n\t\t\t\t********* ");
        MergeSort(array);
        System.out.println();
        insertion(temp);
        System.out.println();
        int tempor[] = new int[size];
        for (int k = size - 1; k >= 0; k--)
            tempor[k] = temp[size - k - 1];
        int tem[] = new int[size];
        for (int k = size - 1; k >= 0; k--)
            tem[k] = array[size - k - 1];
        System.out.println();
        System.out.println("*****************************************************************");
        System.out.println("*****************************************************************");
        System.out.println("\t\t\tChecking for descending array        \n\t\t\t\t********* ");
        MergeSort(tem);
        System.out.println();
        insertion(tempor);
        System.out.println();
        sc.close();
    }
}