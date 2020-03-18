/*
Paul Briones
AD 325 Thursday
WInter 2020

Sorting
Consider an n by n array of integer values.
Write an algorithm to sort the rows of the array by their first value.
Using Big Oh notation, describe the efficiency of your algorithm (put this part as comments right under the class header in your program).
Implement your algorithm.
 */
package com.mycompany.paulbrionestha4;

/**
 *
 * @author pabri
 */
public class BigOhArray {
    //algorithm that I used is sorting, this will be an O(n^2) algorithm.
    public static void main(String[] args) {
        int [][] array = {{1, 2, 3, 4, 5},
                        {3, 4, 5, 1, 2},
                        {5, 2, 3, 4, 1},
                        {2, 3, 1, 4, 5},
                        {4, 2, 3, 1, 5}};
        
        System.out.println("The array initially");
        printarray(array);
        System.out.println();
        System.out.println("The array after sorting");
        shiftarray(array,5,0);
    }
    //simple for loop to print list of 2d array
    public static void printarray(int m[][]) {
        //prints out 2d array
        for (int i = 0; i < m.length; i++) { 
            for (int j = 0; j < m[i].length; j++)  
                System.out.print(m[i][j] + " "); 
            System.out.println();
        } 
    }
    //shifting arrays based on their column
    public static void shiftarray(int[][] m,int n, int c) {
        int key, j;
        for (int i = 1; i < n; i++){
            key = m[i][c];
            int[] keyRow = m[i];
            j = i - 1;
            while ((j >= 0) && (m[j][c] > key)){
            m[j+1] = m[j];
            j--;
            }
            //a[j+1][c] = key;
            m[j+1] = keyRow;
        }
        //prints out after sorting
        for (int i = 0; i < m.length; i++) { 
            for (int l = 0; l < m[0].length; l++)  
                System.out.print(m[i][l] + " "); 
            System.out.println(); 
        }
    }
}
