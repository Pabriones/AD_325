/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha6;

/**
 *
 * @author pabri
 */
public class IntTreeNode {
    //data fuekds
    public int data;
    public IntTreeNode left;
    public IntTreeNode right;

    //constructor to build left node
    public IntTreeNode(int data){
        this(data,null, null);

    }

    //constructor to build the branchnode
    public  IntTreeNode(int data, IntTreeNode  left, IntTreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
