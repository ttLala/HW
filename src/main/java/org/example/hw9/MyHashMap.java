package org.example.hw9;
import  java.util.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap<K, T> {
    private HashElem<K,T> headElem = null;
    private int size = 0;

    public void  put(K key, T value){
        if(size == 0){
            headElem = new HashElem<>(key, value);
            headElem.next = headElem;
            size++;
            return;
        }
        HashElem<K,T> check = headElem.next;
        for (int i = 1; i <= size; i++){
            if(check.next.key.equals(key)){
                return;
            }
            check = check.next;
        }
        HashElem newElem = new HashElem<>(key,value);
        newElem.next = headElem.next;
        headElem.next = newElem;
        headElem = newElem;
        size++;
    }

    public void remove(K key){
        HashElem<K,T> check = headElem.next;
        for (int i = 1; i <= size; i++){
            if(check.next.key.equals(key)){
                check.next = check.next.next;
                size--;
                return;
            }
            check = check.next;
        }
    }

    public void clear(){
        headElem = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T get(K key){
        HashElem<K,T> check = headElem.next;
        for (int i = 1; i <= size; i++){
            if(check.next.key.equals(key)){
                return check.next.value;
            }
            check = check.next;
        }
        return null;
    }
    private class HashElem<K, T>{
        K key;
        T value;
        HashElem<K, T> next = this;
        HashElem(K key, T value){
            this.key = key;
            this.value = value;
        }
    }


}
