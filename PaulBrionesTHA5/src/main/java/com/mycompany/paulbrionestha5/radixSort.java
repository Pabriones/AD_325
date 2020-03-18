/*
Paul Briones
AD 325 Winter 2020
Assignment 5 Thursday

Radix sort

Implement the radix sort algorithm by using a queue for each bucket.

Your program should demonstrate the use of queues in the execution of a radix sort.

In your main method, set up the array as below:
int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,6589, 6622, 1211};
(Please produce the result as the sample run.)
 */
package com.mycompany.paulbrionestha5;

import java.util.*;

/**
 *
 * @author pabri
 */
public class radixSort {
    public static void main(String[] args) {
        int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,6589, 6622, 1211};
        System.out.println("The array before sorting is: ");
        System.out.println(Arrays.toString(list));
        System.out.println();
        
        System.out.println("The array after sorting is:");
        RadixSort(list);
        System.out.println(Arrays.toString(list));
    }
    public static void RadixSort(int[] input) {
    final int RADIX = 10;
    
    // declare and initialize bucket[]
    List<Integer>[] bucket = new ArrayList[RADIX];
    
    for (int i = 0; i < bucket.length; i++) {
      bucket[i] = new ArrayList<Integer>();
    }

    // sort
    boolean maxLength = false;
    int tmp = -1, placement = 1;
    while (!maxLength) {
      maxLength = true;
      
      // split input between lists
      for (Integer i : input) {
        tmp = i / placement;
        bucket[tmp % RADIX].add(i);
        if (maxLength && tmp > 0) {
          maxLength = false;
        }
      }
      
      // empty lists into input array
      int a = 0;
      for (int b = 0; b < RADIX; b++) {
        for (Integer i : bucket[b]) {
          input[a++] = i;
        }
        bucket[b].clear();
      }
      
      // move to next digit
      placement *= RADIX;
    }
  }
}

