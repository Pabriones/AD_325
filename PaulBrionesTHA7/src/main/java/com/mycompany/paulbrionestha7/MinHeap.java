/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha7;
import java.util.*;

/**
 *
 * @author pabri
 */
public class MinHeap <T extends Comparable <? super T>> implements MinHeapInterface <T> {
    //data field
    private int size;
    private T[] heap;
    private boolean integrityOK = false;
    private int lastIndex;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    //constructors
    /*
    @SuppressWarnings("unchecked")
    public MinHeap () {
        // Java doesn't allow construction of arrays of placeholder data types 
        heap = (T[])new Comparable[DEFAULT_CAPACITY];  
        size = 0;
        integrityOK = true;
    }
    */
    @SuppressWarnings("unchecked")
    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }
    public MinHeap (int initialCapacity){
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
            //else
            //checkCapacity(initialCapacity);
            T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
            heap = tempHeap;
            size = 0;
            lastIndex = 0;
            integrityOK = true;
        
    }
    
    public MinHeap (T[] entries){
        /*
        this(entries.length);
        lastIndex = entries.length;
        //copy the original array to the data field array
        for(int index = 0; index < entries.length; index++){
            heap[index + 1] = entries[index];
        }
        for(int rootIndex = lastIndex/2; rootIndex > 0; rootIndex--){
            reheap(rootIndex);
        }
        */
        this(entries.length);
        size = entries.length;
        //copy the original array to the data field array
        for(int index = 0; index < entries.length; index ++)
            heap[index + 1] = entries[index];
        
        //create the heap
        for(int rootIndex = size/2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
        
    }
    
    public void add(T newEntry){
        checkIntegrity();
        int newIndex = lastIndex +1;
        int parentIndex = newIndex/2;
        while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) < 0){
            heap[newIndex] =  heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex/2;
        }//end while
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
        /*
        // grow array if needed
        if (size >= heap.length - 1) {
            heap = this.resize();
        }        
        // place element into heap at bottom
        size++;
        int index = size;
        heap[index] = newEntry;
        
        bubbleUp();
        */
    }
      
     private T[] resize() {
        return Arrays.copyOf(heap, heap.length * 2);
    }
     
     public String toString() {
        return Arrays.toString(heap);
    }
     
     private void bubbleUp() {
        int index = this.size;
        
        while (hasParent(index)
            && (parent(index).compareTo(heap[index]) > 0)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }
    private void bubbleDown() {
        int index = 1;
        
        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);
            
            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index)
                && heap[leftIndex(index)].compareTo(heap[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            } 
            
            if (heap[index].compareTo(heap[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }
            
            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }        
    }
    
    private int leftIndex(int i) {
        return i * 2;
    }
     
    private T parent(int i) {
        return heap[parentIndex(i)];
    }
     
    private int parentIndex(int i) {
        return i / 2;
    }
    private boolean hasParent(int i) {
        return i > 1;
    }
    
    private boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    private boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    private void swap(int index1, int index2) {
        T tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;        
    }
    
    private int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public T getMin() {
        if (this.isEmpty()) {
        }
        return heap[1];
    }
    
    public T removeMin() {
    	// remove the min leaf
    	T result = getMin();
    	
    	// get rid of the last leaf/decrement
    	heap[1] = heap[size];
    	heap[size] = null;
    	size--;
    	bubbleDown();
    	return result;
    }
    private void reheap(int rootIndex){
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2* rootIndex;
        while(!done && (leftChildIndex <= lastIndex)) {//heap[rootIndex] has a child
            //left node is smaller than right node for min heap
            int smallerChildIndex = leftChildIndex;
            //right node is always 1 + leftChildIndex
            int rightChildIndex = leftChildIndex + 1;
            //right side, if right node is greater than left
            if((rightChildIndex <=lastIndex)&&heap[rightChildIndex].compareTo(heap[smallerChildIndex]) < 0){
                smallerChildIndex = rightChildIndex;
            }//end if
            //left side
            if(orphan.compareTo(heap[smallerChildIndex]) >0){
                heap[rootIndex] = heap[smallerChildIndex];
                rootIndex = smallerChildIndex;
                leftChildIndex = 2* rootIndex;
            }else{
                done = true;
            }//end while
            heap[rootIndex] = orphan;
        }
    }
    /*
    private void reheap(int rootIndex){
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = rootIndex * 2;
        while(!done && (leftChildIndex <= lastIndex)){
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0){
                largerChildIndex = rightChildIndex;
            }//end if
            if(orphan.compareTo(heap[largerChildIndex]) < 0){
                heap[rootIndex] = heap [largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = rootIndex * 2;
            }
            else
                done = true;
        }//end while
        heap[rootIndex] = orphan;
    }//end reheap
    */
    private void ensureCapacity(){
        int numberOfEntries = lastIndex;
        int capacity = heap.length -1;
        if(numberOfEntries >= capacity){
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);//Is Capacity too big;
            heap = Arrays.copyOf(heap, newCapacity + 1);
        }//end if
    }// end ensureCapacity
    private void checkCapacity(int capacity){
        if(capacity < DEFAULT_CAPACITY){
            capacity = DEFAULT_CAPACITY;
        }
        else if(capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a heap " + "whose capacity is larger than " + MAX_CAPACITY);
        }//end checkCapacity
    }//end MaxHeap
    private void checkIntegrity(){
        if(!integrityOK){
            throw new SecurityException("MinHeap object is corrupt.");
        }//end checkIntegrity
    }

}

