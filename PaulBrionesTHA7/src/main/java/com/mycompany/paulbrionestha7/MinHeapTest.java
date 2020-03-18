/*
Paul Briones
Assignment 7
AD 325 Winter 2020

MinHeap
Recall that in a minheap, the object in each node is less than or equal to the objects in the node’s descendants.
While a maxheap has the method getMax, and removeMax, a minheap has the method getMin and removeMin instead. Use an array to implement a minheap.
1) Create the 1st MinHeap object and use the add method to add Jared, Brittany, Brett, Doug,
Megan, Jim, Whitney, Matt and Regis in this order individually to the Heap.
Test the add(), isEmpty(), getSize(), getMin(), removeMin() methods

2)Create the 2nd MinHeap object and use the constructor with array parameter. 
Below is the array you need to use in your main method for the 2nd MinHeap object:
String[] nameArray = {"Banana", "Watermelon", "Orange", "Apple", "Kiwi"};
Test the isEmpty(), getSize(), getMin(), removeMin() methods
You will need to submit the MinHeap class, MinHeapInterface class, and the test class for this assignment.  
Make sure you use checkIntegrity(), checkCapacity(), and ensureCapacity() in your MinHeap class.
You will need to use the type parameter, bounded wildcards, and the generic type for this assignment.
 */
package com.mycompany.paulbrionestha7;

/**
 *
 * @author pabri
 */
public class MinHeapTest {
    public static void main(String[] args) {
        MinHeapInterface<String> aHeap = new MinHeap<>();
        aHeap.add("Jared");
        aHeap.add("Brittany");
        aHeap.add("Brett");
        aHeap.add("Doug");
        aHeap.add("Megan");
        aHeap.add("Jim");
        aHeap.add("Whitney");
        aHeap.add("Matt");
        aHeap.add("Regis");
        
        System.out.println("The heap is not empty; it contains " + aHeap.getSize() + " entries");
        System.out.println("The smallest entry is " + aHeap.getMin());
        System.out.println("Removing entries in ascending order:");
        while(!aHeap.isEmpty())
            System.out.println("Removing " + aHeap.removeMin());
        
        //part 2
        System.out.println();
        String[] list = {"Banana", "Watermelon", "Orange", "Apple", "Kiwi"};
        MinHeapInterface<String> aHeap1 = new MinHeap<>(list);
        System.out.println("Testing constructor with array parameter:");
        System.out.println(aHeap1);
        System.out.println("The heap is not empty; it contains " + aHeap1.getSize() + " entries.");
        System.out.println("The smallest entry is " + aHeap.getMin());
        System.out.println("Removing entries in ascending order:");
        while(!aHeap1.isEmpty())
            System.out.println("Removing " + aHeap1.removeMin());
    }
}

