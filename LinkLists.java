package code.Java;

import java.util.*;

class LinearList
{
    Node HeadNode;
    int size = 0;
    class Node
        {
        Object data;
        Node next;
        Node(Object data)  
        {
            this.data = data;
            this.next = null;
        }
    }
    //removing a element from given 
    void remove(int ind)
    {
        checkIndex(ind);
        Node current = ind(ind - 1);
        current.next = current.next.next;
        this.size--;
    }
    //adding a element
    void add(Object q)
    {
        Node newNode = new Node(q);
        if(HeadNode == null)
        {
            HeadNode = newNode;
        }
        else 
        {
            Node last = null;
            for(last = HeadNode ; last.next!=null;last = last.next);
            last.next = newNode;
        }
        size++;
    }
    //inserting a element
    void insert(int ind , Object q)
    {
        checkIndex(ind);
        if(ind > 0)
        {
            Node previous = ind(ind-1);
            Node new_node = new Node(q);
            new_node.next = previous.next;
            previous.next = new_node;
        }
        else if(ind == 0)
        {
            Node new_node = new Node(q);
            new_node.next = HeadNode;
            HeadNode = new_node;
        }
        size++;
    }
    //getting the data in the node
    Object get(int ind)
    {
        checkIndex(ind);
        Node current = ind(ind);
        return current.data;
    }
    //getting the index of an Object
    int indexOf(Object mat)
    {
        Node pq = HeadNode;
        int ind = -1;
        for(int i = 0 ; i < this.size ; i++)
            {
                if(pq.data.equals(mat))
                {
                    ind = i;
                    break;
                }
            else pq = pq.next;
        }
        return ind;
    }
    //is list empty?
    boolean isEmpty()
    {
        if(HeadNode==null)
        return true;
        else return false;
    }
    //Print the list
    void printList()
    {
        Node pq = HeadNode;
        System.out.print("{");
        for(int i = 0 ; i < size ; i++)
        {
            System.out.print(" [" + pq.data + "] ");
            pq = pq.next;
        }
        System.out.println("}");
    }
    //checking valid index
    void checkIndex(int ind)
    {
        if(ind<0 || ind>=size)
        throw new IndexOutOfBoundsException ("invalid index");
    }
    //function for iterating the list.
    Node ind(int ind)
    {
        Node indexedNode = HeadNode;
        for(int i = 0 ; i < ind ; i++)
        {
            indexedNode = indexedNode.next;
        }
        return indexedNode;
    }
}
public class LinkLists
{
    public static void main(String[] args) 
    {
        LinearList linklist = new LinearList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of input : ");
        int entry = sc.nextInt();
        sc.nextLine();
        //To add element
        for(int i = 0 ; i < entry ; i++)
        {
            linklist.add(sc.nextLine());
        }
        //to print list
        linklist.printList();
        //to access index position
        System.out.print("Type index position of the element : ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.println("Element at " + index + " is : " + linklist.get(index));//showing element at given index
        //to find the index of given element
        System.out.print("Type your element to find its index : ");
        Object obj = sc.nextLine();
        System.out.println("Index Of " + (obj) + " is : " + linklist.indexOf(obj));
        //to remove element of given index
        System.out.print("Type an index to remove an element : " );
        linklist.remove(sc.nextInt());
        sc.nextLine();
        
        System.out.println("After removal");
        linklist.printList();
        // to insert an element at the given index
        System.out.print("Type the index and element to insert int the list : " );
        linklist.insert(sc.nextInt(),sc.nextLine());
        linklist.printList();
        
        System.out.println(linklist.isEmpty()?"list is empty" : "list is not empty");
        sc.close();
    }
}