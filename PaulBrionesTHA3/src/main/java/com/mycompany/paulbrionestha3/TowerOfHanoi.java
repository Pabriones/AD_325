/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha3;

/**
 *
 * @author pabri
 */
public class TowerOfHanoi {
    // Java recursive function to solve tower of hanoi puzzle 
    static int count = 0; //moves counter
    
    //first solution
    static void TowerOfHanoi(int n, char start, char temp, char end){ 
        if (n == 1){ 
            System.out.println("Move disk " + n + " from " +  start + " to " + end); 
            count++;
        }else{
            TowerOfHanoi(n-1, start, end, temp);
            System.out.println("Move disk " + n + " from " + start + " to " + end);
            TowerOfHanoi(n-1, temp, start, end);
            count ++;
        }
    } 
      
    //  test method
    public static void main(String args[]) { 
        System.out.println("Compare the two solveTowers methods for 3 disks:");
        System.out.println();
        
        int n = 3; // Number of disks 
        TowerOfHanoi(n, '1', '2', '3');  // 1, 2, and 3 are names of rods
        System.out.println("");
        System.out.println("Tower size of 3 solved with " + count + " recursive calls using the first solveTowers method.");
        System.out.println();
        
        int num  = 3;
        TowerOfHanoi(num,'1','2','3');
        System.out.println("");
        System.out.println("Tower size of 3 solved with " + count + " recursive calls using the second solveTowers method.");
        System.out.println();
    }
}
