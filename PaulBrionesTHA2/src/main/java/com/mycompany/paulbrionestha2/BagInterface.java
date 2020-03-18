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
public interface BagInterface <T> {
     boolean add(T newEntry);
     T[] toArray();
     void clear();
     boolean isEmpty();
     boolean contains (T newEntry);
     T remove();
     int getCurrentSize();
     boolean remove(T anEntry);
     int getFrequencyOf(T anEntry);
     void removeEvery(T anEntry);
     void replace(T anEntry);
}
