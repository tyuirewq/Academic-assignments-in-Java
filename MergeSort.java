package code.Java;

import java.util.*;
class MergeSort{
    void merge(int arr[], int a,int b,int c){
        int p1 = b - a + 1;
        int p2 = c- b;
        int A[] = new int [p1];
        int C[] = new int [p2];
        for(int i = 0;i <p1; ++i)       A[i] = arr[a + i];
        for(int j = 0;j <p2; ++j)       C[j] = arr[b + 1 + j];
        int i = 0, j = 0;
        int z = a;
        while(i<p1 && j < p2){
            if (A[i] <= C[j]){
                arr[z] = A[i];
                i++;
            }
            else{
                arr[z] = C[j];
                j++;
            }
            z++;
        }
        while(i < p1){
            arr[z] = A[i];
            i++;
            z++;
        }
        while(j < p2){
            arr[z] = C[j];
            j++;
            z++;
        }

    }
    void sorting(int array[], int a,int c){
        if (a< c){
            int b = a + (c - a)/2;
            sorting(array, a , b);
            sorting (array, b + 1 , c);
            merge(array, a , b , c );

        }
    }
    static void printArray(int array[]){
        int n = array.length;
        for( int i = 0; i<n; ++i){
            System.out.print(array[i] +  "  ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.print("Give the size of array   :   ");
       int size = sc.nextInt();
       int array[] = new int [size];
       Random r = new Random();
       for (int i = 0; i<size;i++){
           int low =  1;
           int high = 500;
           int result = r.nextInt(high-low)+ low;
           if (result != 0){
           array[i] = result;  
           }
       }
       System.out.println("Before Sorting Our Random Array " );
       printArray(array);
       MergeSort ob = new MergeSort();
       long start = System.nanoTime();
       ob.sorting(array, 0, array.length - 1);
       long stop = System.nanoTime();
       System.out.println();
       System.out.println(stop - start);
       System.out.println();
       System.out.println("After Sorting Our Random Array " );
       printArray(array);
       sc.close();
    }
}


