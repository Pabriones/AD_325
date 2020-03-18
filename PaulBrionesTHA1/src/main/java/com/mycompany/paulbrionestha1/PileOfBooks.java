/*
Paul Briones
AD 325 Thursday
Winter 2020

Imagine a pile of books on your desk. Each book is so large and heavy that you can remove only the top one from the pile. 
You cannot remove a book from under another one. Likewise, you cannot add a book beneath another one. 
You can add another book to the pile only by placing it on the top of the pile.
If you represent books by their titles alone, design a class that you can use to track the books in the pile on your desk.
Specify each operation by stating its purpose, by describing its parameters, and by writing a pseudocode version of its header.
Then write a Java interface for the pile’s methods. Include javadoc-style comments in your code.
Define a class PileOfBooks that implements this interface. Use a resizable array in your implementation.
Then write a program that adequately demonstrates your implementation.
In this program, you will need to have 1 class with the name as PileOfBooks, 1 interface with the name as PileInterface,
and 1 test class to test everything.
 */
package com.mycompany.paulbrionestha1;

import java.util.*;

/**
 *
 * @author pabri
 */
public class PileOfBooks<T> implements PileInterface<T> {
     //data fields
    private int numBooks;
    private T[]pile;
    private static final int DEFAULT_CAPACITY = 4;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;
            
     //default constructor
    public PileOfBooks(){
        this(DEFAULT_CAPACITY);   
    }
    
    public PileOfBooks(int desiredCapacity){
        if (desiredCapacity <= MAX_CAPACITY){
            T[] tempBag = (T[]) new Object[desiredCapacity];
            pile = tempBag;
            numBooks = 0; //empty bag
            integrityOK = true;
        }
        else{
            throw new IllegalStateException("Attempt to create a pile whose capacity exceeds allowed maximum.");
        }
    }
    
    
    public boolean add(T newBook){
        checkIntegrity();
        boolean result = true;
        if (isPileFull()){
            doubleCapacity();
            pile[numBooks] = newBook;
            numBooks++;
        }
        else{
            pile[numBooks] = newBook;
            numBooks++;
        }
        return result;
    }
    
    private boolean isPileFull(){
        return numBooks >= pile.length;
    }
    
    //return the entries in the bag
    public T[] toArray(){
        T[] result = (T[]) new Object[numBooks];
        for (int index = 0; index < numBooks; index++){
            result[index] = pile[index];
        }
        return result;
    }
    
    public T remove(){
        checkIntegrity();
        T result = null;
        if(numBooks >0){
            numBooks--;
            result = pile[numBooks];
            pile[numBooks] = null;
        }
        return result;
    }
    
    public void clear(){
        while(!isEmpty()){
            remove();
	}
    }
    
    public boolean isEmpty(){
	//return true if top is -1, means null
	return numBooks == 0;
    }
    public T getTopBook(){
        if(isEmpty()){
            return null;
        }
        int topBook = numBooks - 1;
        return pile[topBook];
    }
    //Throws an exception if this object is not initialized
    private void checkIntegrity(){
        if(!integrityOK){
            throw new SecurityException("Pile object is corrupt");
        }
    }
    
    //throws an exception if the client requests a capacity that is too large
    private void checkCapacity(int capacity){
        if(capacity>MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a pile whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }
    
    //double the size of the array pile
    private void doubleCapacity(){
        int newLength = 2 * pile.length;
        checkCapacity(newLength);
        pile = Arrays.copyOf(pile,newLength);
    }
}
