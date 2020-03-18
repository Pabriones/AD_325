/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.paulbrionestha7;

/**
 *
 * @author pabri
 */
public interface MinHeapInterface <T extends Comparable<? super T>> {
    public void add(T newEntry);
    public boolean isEmpty();
    public int getSize();
    public T getMin();
    public T removeMin();
}
