/*
Paul Briones
AD 325 Winter 2020
Assignment 6 Thursday 

Binary Search Tree

Write a method called countLeftNodes that returns the number of left children in the tree. A left child is a node that appears as the root of the left-hand subtree of another node.
Write a method called isFull that returns true if a binary tree is full and false if it is not. A full binary tree is one in which every node has 0 or 2 children. By definition, the empty tree is considered full.
Add these 2 methods to your existing IntSearchTree class, you will need to include the IntTreeNode class as well in this assignment.  Create another test class to test these 2 methods along with the existing methods in your IntSearchTree class.

In your main method in the test class, create 2 IntSearchTree objects.

set up 2 arrays as below:

int[] list = {55,29,87,-3,42,60,91};

int[] list1 = {60,55,100,45,57};   
 */
package com.mycompany.paulbrionestha6;

/**
 *
 * @author pabri
 */
public class IntSearchTree {
    private IntTreeNode overallRoot;


    //construct an empty tree
    public IntSearchTree(){
        overallRoot = null;
    }

    //add method
    public void add(int value){
        overallRoot = add(overallRoot,value);
    }

    private IntTreeNode add(IntTreeNode root, int value){
        if(root == null){
            root = new IntTreeNode(value);
        }else if(value < root.data){
            root.left = add(root.left,value);

        }else if(value > root.data){
            root.right = add(root.right, value);
        }
        return root;
    }

    public boolean contains(int value){
        return contains(overallRoot, value);
    }

    private boolean contains(IntTreeNode root, int value){
        if(root == null){
            return false;
        }else if(value == root.data){
            return true;
        }else if(value < root.data){
            return contains(root.left, value);
        }else{//value > root.data
            return contains(root.right, value);
        }
    }

    public void print(){
        printInorder(overallRoot);
        System.out.println();
    }

    private void printInorder(IntTreeNode root){
        if(root != null){
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
           
        }
    }
    public void printSideways(){
        printSideways(overallRoot, " ");
    }

    private void printSideways(IntTreeNode root, String indent){
        if(root!= null){
            printSideways(root.right, indent + "     ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "     ");
        }
    }
    
    public boolean isFull() {
    return isFull(overallRoot);
}

    public boolean isFull(IntTreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right != null) {
            return false;
        } else if (root.right == null && root.left != null) {
            return false;
        } else {
            return isFull(root.left) && isFull(root.right);
        }
    }
    public int countLeftNodes() {
        return countLeftNodes(overallRoot);
    }

    public int countLeftNodes(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null) {
            return 1 + countLeftNodes(root.left) + countLeftNodes(root.right);
        } else {
            return countLeftNodes(root.right);
        }  
    }
    
}
