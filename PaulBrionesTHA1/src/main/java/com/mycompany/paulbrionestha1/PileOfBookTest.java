/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha1;

/**
 *
 * @author pabri
 */
public class PileOfBookTest {
    public static void main(String[] args) {
        PileInterface<String> myPile = new PileOfBooks<>();
        System.out.println("isEmpty() return " + myPile.isEmpty());
        System.out.println("Add to pile");
        myPile.add("And Then There Were None");
        myPile.add("The Hobbit");
        myPile.add("The Lord of the Rings");
        myPile.add("The Da Vinci Code");
        myPile.add("The Catcher in the Rye");
        
        System.out.println();
        
        System.out.println("isEmpty() return " + myPile.isEmpty());
        System.out.println(myPile.getTopBook() + " is at the top of the pile");
        System.out.println(myPile.remove() + " is removed from the pile");
        System.out.println();
        System.out.println(myPile.getTopBook() + " is at the top of the pile");
        System.out.println(myPile.remove() + " is removed from the pile");
        System.out.println();
        System.out.println(myPile.getTopBook() + " is at the top of the pile");
        System.out.println(myPile.remove() + " is removed from the pile");
        System.out.println();
        System.out.println(myPile.getTopBook() + " is at the top of the pile");
        System.out.println(myPile.remove() + " is removed from the pile");
        System.out.println();
        System.out.println(myPile.getTopBook() + " is at the top of the pile");
        System.out.println(myPile.remove() + " is removed from the pile");
        System.out.println();
        System.out.println("isEmpty() return " + myPile.isEmpty());
        
        myPile.add("And Then There Were None");
        myPile.add("The Hobbit");
        myPile.add("The Lord of the Rings");
        myPile.add("The Da Vinci Code");
        myPile.add("The Catcher in the Rye");
        System.out.println("Add to the pile");
        System.out.println("isEmpty() return " + myPile.isEmpty());
        System.out.println("Testing Clear:");
        myPile.clear();
        System.out.println("isEmpty() return " + myPile.isEmpty());
        //myPile.printAllBooks();
        System.out.println("getTopBook() return " + myPile.getTopBook());
        System.out.println("remove() return " + myPile.remove());
    }

}
