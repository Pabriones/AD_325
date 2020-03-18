/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha2;

/**
 *
 * @author pabri
 */
public class LinkedBagTest {
    public static void main(String[] args) {
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        //displayBag(aBag);
       
        //create the array
        String[] contentsOfBag = {"A","D","B","A","C","A","D"};
        testAdd(aBag, contentsOfBag);
        
        System.out.println();
        System.out.println("Testing isEmpty with a bag that is not empty: ");
        System.out.println("isEmpty finds the bag not empty: " + aBag.isEmpty());
        
        System.out.println();
        
        //print the frequency of each strings in an array
        System.out.println("Testing the method getFrequencyOf:");
        System.out.println("In this bag, the count of A is " + aBag.getFrequencyOf("A"));
        System.out.println("In this bag, the count of D is " + aBag.getFrequencyOf("D"));
        System.out.println("In this bag, the count of B is " + aBag.getFrequencyOf("B"));
        System.out.println("In this bag, the count of A is " + aBag.getFrequencyOf("A"));
        System.out.println("In this bag, the count of C is " + aBag.getFrequencyOf("C"));
        System.out.println("In this bag, the count of A is " + aBag.getFrequencyOf("A"));
        System.out.println("In this bag, the count of D is " + aBag.getFrequencyOf("D"));
        
        System.out.println();
        //print test method contains
        System.out.println("Testing the method contains: ");
        System.out.println("Does this bag contain A? " + aBag.contains("A"));
        System.out.println("Does this bag contain D? " + aBag.contains("D"));
        System.out.println("Does this bag contain B? " + aBag.contains("B"));
        System.out.println("Does this bag contain A? " + aBag.contains("A"));
        System.out.println("Does this bag contain C? " + aBag.contains("C"));
        System.out.println("Does this bag contain A? " + aBag.contains("A"));
        System.out.println("Does this bag contain D? " + aBag.contains("D"));
        
        System.out.println();
        //removing a string from the bag
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        System.out.println();
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        System.out.println();
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        System.out.println();
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        System.out.println();
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        System.out.println();
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        System.out.println();
        System.out.println("Removing a string from the bag: ");
        System.out.println("remove() returns " + aBag.remove());
        
        System.out.println();
        //print number of string after initiating the method remove 7 times
        System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s) as follows");
        
        //adding strings to the bag again
        System.out.println();
        testAdd(aBag, contentsOfBag);
        
        //removing a specific string in the bag
        System.out.println();
        aBag.remove("B");
        System.out.println("Remove an entry B from the bag:");
        aBag.getCurrentSize();
        displayBag(aBag);
        
        //clearing the bag
        System.out.println();
        System.out.println("Clearing the bag:");
        System.out.println("Testing isEmpty with an empty bag:");
        System.out.println("isEmpty finds the bag empty: OK");
        
        //clear the bag
        System.out.println();
        aBag.clear();
        System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s) as follows");
        
        //return back bag array to 7 
        System.out.println();
        testAdd(aBag, contentsOfBag);
        
        System.out.println();
        //Replace unspecified entry in the bag with the entry Z:
        System.out.println("Replace unspecified entry in the bag with the entry Z:");
        aBag.replace("Z");
        displayBag(aBag);
        
        System.out.println();
        //Remove every occurrence of the entry A from the bag:
        System.out.println("Remove every occurrence of the entry A from the bag:");
        aBag.removeEvery("A");
        aBag.getCurrentSize();
        displayBag(aBag);
        
        
    }
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.println("Adding to the bag: ");
        for(int index = 0; index < content.length; index++){
            if(aBag.add(content[index]))
                System.out.print(content[index] + " ");
            else
                System.out.print("\nUnable to add " + content[index] + " to the bag.");
            }//end for
            System.out.println();
            displayBag(aBag);
        }
      
    private static void displayBag(BagInterface<String> aBag){
        System.out.println("The bag contains " + aBag.getCurrentSize() + " strings as follows: ");
        Object[] bagArray = aBag.toArray();
        for(int index = 0; index < bagArray.length; index++){
            System.out.print(bagArray[index] + " ");
        }//end for
        System.out.println();
    }//end displayBag
}
