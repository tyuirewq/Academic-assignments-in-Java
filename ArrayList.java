package code.Java;

import  java.util.*;
class QueueAL{
     int front,rear,capacity;
     int queue[];

    QueueAL(int c){
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    } 
    public int Sizeof(){
        return capacity;
    }
    public boolean isEmpty(){
        return (queue== null);
    }
    // enqueue is for adding element at the end of arraylist
     void enqueue(int data){
        if (capacity == rear){
            System.out.println("\n Queue is full \n");
            return;
        }
        else {queue[rear] = data;rear++;}
        return;
    }
    // dequeue is for removing element from the beginning of arraylist
     void dequeue(){
        if (front == rear){
            System.out.println("\n Queue is empty \n");
            return;
        }

        else {
            for (int i = 0;i<rear -1;i++){
                queue[i] =  queue[i + 1];
            }
            if(rear<capacity){
                queue[rear] = 0;
            }
            rear--;
        }
        return;
    }
    //to show the element of arraylist
     void display(){
        int i  ;
        if (front == rear){
            System.out.printf("\n Queue is empty \n");
            return;
        }
        for (i = front; i<rear; i++){
            System.out.printf("\n  -->   %d       ",queue[i]);
        }
        return;
    }
    // to give the first element of arraylist
     void eqFront(){
        if (front == rear){
            System.out.printf("\n Queue is empty \n");
            return;
        }
        System.out.printf(" \n Front ELement is :  %d\n",queue[front]);
    }
}
class QllNode {
    int key ;
    QllNode next;
    public QllNode (int key){
        this.key = key;
        this.next = null;
    }
}
class QueueLL{
    QllNode front, rear;
    public QueueLL(int m){
        this.front = this.rear = null;
    }
    // equeue is for adding element at the end of linkedlist
    void equeue(int key){
        QllNode temp = new QllNode(key);
        if(this.rear == null){
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    void dequeue(){
        if(this.front == null){
            return;
        }
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
    }
    void disp(){
        if (front == null){
            System.out.println("Underflow");
        }
        else{
            QllNode current = front;
            while(current != null){
                System.out.println("                  " +current.key);
                current = current.next;
            }
        }
    }
}

public class Application{
   public static void main(String[] args) {
    System.out.println("********************************\n");
       System.out.printf("\nEnter the Size of ArrayList     :   ");
       Scanner sc = new Scanner(System.in);
       int size = sc.nextInt();
       QueueAL q = new QueueAL(size);
       System.out.println("\nEnter the elements :    ");
       for(int w = 0;w<size;w++){
           q.enqueue(sc.nextInt());
       }
       System.out.println("\n********************************");
       System.out.println("All elements are     \n");
       q.display();
       q.eqFront();
       System.out.println("\n********************************");
       System.out.printf("Enter the no. of element you want to remove  ");
       int rem = sc.nextInt();
       for(int w = 0;w<rem;w++){
            q.dequeue();
       }
       System.out.printf("\nAfter Deletion remaining elements  are   \n\n");
       q.display();
       q.eqFront();
       System.out.println("The size of arraylist is  " + q.Sizeof());
    System.out.println("Is ArrayList is empty      ?    " + q.isEmpty());
       System.out.println("\n.........................................................");
       System.out.println(".........................................................");
       System.out.printf("Enter the size of your LinkedList    ");
        int m = sc.nextInt();
       QueueLL PQ = new QueueLL(m);
       System.out.println("Enter the elements :    ");
       for(int w = 0;w<m;w++){
           PQ.equeue(sc.nextInt());
       }
       System.out.println("*****************************************");
       System.out.print(" Elements are  :  \n");
       PQ.disp();
       System.out.printf("\nFront ELement     " + PQ.front.key);
       System.out.printf("\nRear Element      " + PQ.rear.key);
       System.out.println("\n*****************************************");
       System.out.printf("\nEnter the no. of element you want to remove   ");
       int n = sc.nextInt();
       for(int w = 0;w<n;w++){
            PQ.dequeue();
       }
       System.out.printf("\nAfter Deletion  \n");
       PQ.disp();
       System.out.printf("\nFront ELement     " + PQ.front.key);
       System.out.printf("\nRear Element      " + PQ.rear.key);
       System.out.println("\n*****************************************");
       sc.close();
   }
}
// Hariom Kaushal 
// 202051080