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
public interface PileInterface<T> {
    boolean add(T newBook);
    void clear();
    T[] toArray();
    T remove();
    T getTopBook();
    boolean isEmpty();
    
}
