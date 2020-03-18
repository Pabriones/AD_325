/*
Paul Briones
AD 325
Winter 2020
Thursday Assignment 2

In this program, you will need to have 1 class with the name as LinkedBag, 1 interface with the name as BagInterface, and 1 test class to test everything.

(Please finish your LinkedBag class and write a program that thoroughly test the class LinkedBag)

In your test program, create the following array and add to the bag.

String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};

testAdd(aBag, contentsOfBag);

Then you will need to add the same set of items a few time later in your test program.

You will need to create the following methods headers in your BagInterface and the detailed implementation of each methods 
in your LinkedBag class.

The add method should add a new entry to the bag.

The remove method should remove one unspecified entry from the bag, if possible.

The remove(T anEntry) method should remove one occurrence of a given entry from the bag, if possible.

The getCurrentSize method should get the current number of entries in the bag.

The isEmpty method should detect whether the bag is empty.

The clear method should remove all entries from the bag.

The getFrequencyOf method should count the number of times an Entry appears in the bag.

The contains method should test whether the bag contains a given entry.

The toArray method should retrieve all entries that are in the bag.

The replace method should replace an unspecified entry in the bag with a given object.

The removeEvery method should remove every occurrence of a given entry from the bag.
 */
package com.mycompany.paulbrionestha2;
import java.util.*;
/**
 *
 * @author pabri
 */
public class LinkedBag <T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;
    private T[]pile;
    
    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }
    
    private class Node{
        //datafield
        private T data;
        private Node next;
        
        //constructor for node class
        private Node (T dataPortion){
            this(dataPortion,null);
        }
        
        //another constructor for the node class
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
    }//end of Node class
    
    public boolean add(T newEntry){
        //add to beginning of the chain
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }
    
    //retrieve all entries in the bag
    //@return the array
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }//end while
        return result;
    }
    
    public T remove(){
        T result = null;
      	if (firstNode != null){
            result = firstNode.data; 
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
     	} // end if
        return result;
    } // end remove
    
    public void clear(){
        while(!isEmpty()){
            remove();
	}
    }
    
    public boolean isEmpty(){
	//return true if top is -1, means null
	return numberOfEntries == 0;
    }
    
    public boolean contains(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
      
        while (!found && (currentNode != null)){
            if (anEntry.equals(currentNode.data))
            found = true;
            else
            	currentNode = currentNode.next;
        } // end while
        return found;
    } // end contains
    
    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry){
        boolean found = false;
	Node currentNode = firstNode;
	while (!found && (currentNode != null)){
            if (anEntry.equals(currentNode.data))
		found = true;
            else
		currentNode = currentNode.next;
	} // end while
        return currentNode;
    } // end getReferenceTo
    
    /** Removes one specified entry from this bag, if possible.
       @return  Either true or false*/
    public boolean remove(T anEntry){
	boolean result = false; 
	Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null){
            nodeN.data = firstNode.data; //Replace located entry with entry in 1st 
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;  
            result = true;
      	} // end if
            return result;
    } // end remove

    public int getCurrentSize(){
        return numberOfEntries;
    }
    
    public int getFrequencyOf(T anEntry){
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null)){
            if (anEntry.equals(currentNode.data)){
                frequency++;
            }
            counter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }
    
    public void replace(T anEntry){
        firstNode.data = anEntry;
    }
    
    public void removeEvery(T anEntry){
        while(contains(anEntry)){
            remove(anEntry);
        }
    }
    
}
