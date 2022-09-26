import java.util.*;

public class selection_sorting {
// This is the method for selection sorting Algorithm
    static void selection_sorting_Code(int array[]) {
        int initialindex = array.length - 1;
        // main loop to sort
        // intial index is (array size - 1) 
        // second array index is 0 initially
        while (initialindex >= 1) {
            int maximum = initialindex;
            int secondarrayindex = 0;
            while (secondarrayindex < initialindex) {
                if (array[secondarrayindex] >= array[initialindex]) {
                    maximum = secondarrayindex;
                    // Here we are swapping the array[maximum] to array[initialindex] and vice-versa
                    int swap = array[maximum];
                    array[maximum] = array[initialindex];
                    array[initialindex] = swap;
                }
                secondarrayindex++;
            }
            initialindex--;
        }
    }
// This is the code for Bubble Sorting method
    static void bubbleSort_Code(int array[]) {
        for (int initialindex = 0; initialindex <  array.length - 1; initialindex++) {
            for (int secondarrayindex = 0; secondarrayindex < array.length - initialindex - 1; secondarrayindex++) {
                if (array[secondarrayindex] > array[secondarrayindex + 1]) {
                    // swapping array[secondarrayindex+1] and array[secondarrayindex]
                    int temp = array[secondarrayindex];
                    array[secondarrayindex] = array[secondarrayindex + 1];
                    array[secondarrayindex + 1] = temp;
                }
            }
        }
    }
// this is the code for Insertion Sorting Method
    static void Insertion_Sort_Code(int array[]) {
        int ArraySIze = array.length;
        for (int initialposition = 1; initialposition < ArraySIze; ++initialposition) {
            int Main = array[initialposition];
            int secondarrayindex = initialposition - 1;

            while (secondarrayindex >= 0 && array[secondarrayindex] > Main) {
                array[secondarrayindex + 1] = array[secondarrayindex];
                secondarrayindex = secondarrayindex - 1;
            }
            array[secondarrayindex + 1] = Main;
        }
    }
// this code is for Linear Search method
static int Linear_Searching_Code(int[] Array, int number) {
    for (int i = 0; i < Array.length; i++) {
        if (number == Array[i])
            return i;
    }
    return -1;
}
// This code is for binary search
    static int binarySearch(int[] array, int n) {
        int a = 0, size = array.length - 1;
        while (a <= size ) {
            int middle = a + (size - 1) / 2;
            if (array[middle] == n) { 
                return middle;
            }
            if (array[middle] < n) { 
                a = middle + 1;
            } else { 
                size = middle - 1;
            }
        }
        return -1;
    }

    // to print an array
    static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the size of Your Array  :   ");
        int size = sc.nextInt();
        int array[] = new int[size];
        // This is for generating the random element for Array
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int low = 1;
            int high = 2000;
            int result = r.nextInt(high - low) + low;
            if (result != 0)
                array[i] = result;
        }
        // System.out.println("\nBefore Sorting Our Random Array is ");
        // printArray(array);
        System.out.println();
        int temp[] = new int[size];
        for (int k = 0; k < size; k++)
            temp[k] = array[k];
        int tempora[] = new int[size];
        for (int k = 0; k < size; k++)
        tempora[k] = array[k];
        int tem[] = new int[size];
        for (int k = 0; k < size; k++)
            tem[k] = array[k];
        // Total 4 array with same element at the same index
        System.out.println();
        // This is for random case
        //here we are calculating time taken by selection sort 
        long start = System.nanoTime();
        selection_sorting_Code(array);
        long stop = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by Selection Sort is ");
        System.out.print(stop - start);
        System.out.println();
        System.out.println();
        //here we are calculating time taken by bubble sort 
        long starts = System.nanoTime();
        bubbleSort_Code(temp);
        long stops = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by Bubble Sort is ");
        System.out.print(stops - starts);
        System.out.println();
        System.out.println();
        //here we are calculating time taken by insertion sort 
        long star = System.nanoTime();
        Insertion_Sort_Code(tempora);
        long sto = System.nanoTime();
        System.out.println();
        System.out.print("Time Taken by Insertion Sort is ");
        System.out.print(sto - star);
        System.out.println();
        // here we are going to take input for searching an element
        System.out.println("\nEnter the element to search   :   ");
        int searching = sc.nextInt();
        //here we are calculating time taken by Linear Search 
        long pq = System.nanoTime();
        Linear_Searching_Code(tem,searching);
        long qp = System.nanoTime();
        int ind = Linear_Searching_Code(array, searching);
        if (ind == -1)
            System.out.println("\n"+searching + " not Found.");
        else
            System.out.println("\n"+searching + " Found at Index = " + ind);
        System.out.println();
        System.out.print("Time Taken by Linear search is ");
        System.out.print(qp - pq);
        System.out.println();
          //here we are calculating time taken by Binary Search 
        long pqr = System.nanoTime();
        binarySearch(tem,searching);
        long rqp = System.nanoTime();
        System.out.println();
        int index = binarySearch(tem,searching);
        System.out.println();
        // System.out.println("Index Value " + index);
        System.out.println();
        if (index == -1)
            System.out.println(searching + " not Found.");
        else
            System.out.println(searching + " Found at Index = " + index);
        System.out.print("Time Taken by Binary search is ");
        System.out.print(rqp - pqr);
        System.out.println();
        sc.close();
    }
}
//Hariom Kaushal
//202051080
