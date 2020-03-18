/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha6;

import java.util.Arrays;


/**
 *
 * @author pabri
 */
public class IntSearchTreeClient {
    public static void main(String[] args) {
        IntSearchTree tree = new IntSearchTree();
        tree.add(55);
        tree.add(29);
        tree.add(87);
        tree.add(-3);
        tree.add(42);
        tree.add(60);
        tree.add(91);
        int[] list = {55,29,87,-3,42,60,91};
        int[] list1 = {60,55,100,45,57};   
        //int[] list1 = {60,55,100,45,57}; 
        
        IntSearchTree tree1 = new IntSearchTree();
        tree1.add(60);
        tree1.add(55);
        tree1.add(100);
        tree1.add(45);
        tree1.add(57);
        
        
        //list
        System.out.println("The original Array is:");
        System.out.println(Arrays.toString(list));
        System.out.println("Tree structure");
        tree.printSideways();
        System.out.println("Sorted list:" );
        tree.print();
        System.out.println();
        System.out.println("The number of left nodes is " + tree.countLeftNodes());
        System.out.println("This is a full binary tree: " + tree.isFull());
        System.out.println();
        //list1
        System.out.println("The original Array is:");
        System.out.println(Arrays.toString(list1));
        System.out.println("Tree structure");
        tree1.printSideways();
        System.out.println("Sorted list:");
        tree1.print();
        System.out.println("The number of left nodes is " + tree1.countLeftNodes());
        System.out.println("This is a full binary tree: " + tree1.isFull());
        System.out.println();
        
    }
    public static void printarray(int m) {
        //prints out array
        System.out.println(m);
    }
}
