package code.Java;

import java.util.Random;
import java.util.Scanner;

public class heapSort
{
    private static int[] a;
    private static int n , left ,right ,  largest;
    static void randomarray(int arr[] , int size ) 
	{
        Random prand = new Random();
        for (int i = 0; i < size; i++) {
            int low = 100;
            int high = 999;
            int result = prand.nextInt(high - low) + low;
            if (result != 0)
                arr[i] = result;
        }
    }
    // Max-Heap Function
    public static void maxheap(int[] a, int i){
    	left=2*i;
    	right=2*i+1;
    	if(left <= n && a[left] > a[i]){
    		largest=left;
    	}
    	else{
    		largest=i;
    	}
    	if(right <= n && a[right] > a[largest]){
    		largest=right;
    	}
    	if(largest!=i){
    		swapping(i,largest);
    		maxheap(a, largest);
    	}
    }
    
    public static void swapping(int i, int j){
    	int t=a[i];
    	a[i]=a[j];
    	a[j]=t; 
    }
    static void print(int arr[]) {
            for (int i = 0; i < arr.length; i++) {
                if (i % 10 == 0 && i != 0) {
                    System.out.print(arr[i] + "       ");
                    System.out.println();
                } else {
                    System.out.print(arr[i] + "            ");
                }
            }
            System.out.println();
        }
    // Sort Function
    public static void sort(int []a1){
    	a=a1;
		n=a.length-1;
    	for(int i=n/2;i>=0;i--)	maxheap(a,i);
    	
    	for(int i=n;i>0;i--){
    		swapping(0, i);
    		n=n-1;
    		maxheap(a, 0);
    	}
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array   : ");
		System.out.print("	");
        int size = sc.nextInt();
		int []a1=new int [size];
		System.out.println(); 
		System.out.println("If you want to enter the element of the array \n\tthen enter 1\n\telse enter 0 \n\n");
		int choice = sc.nextInt();
		if (choice == 1) {
			for (int i = 0; i < a1.length; i++) {
				a1[i] = sc.nextInt();
			}
		}
		else {
			randomarray(a1, size);
		}
        System.out.println();   
        print(a1);
        System.out.println();   
    	sort(a1);
        System.out.println();     
    	print(a1);
        System.out.println();   
        sc.close();
	}
} 

// Hariom Kaushal
// 202051080