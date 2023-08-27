package org.example.hw9;

public class MyQueue<K>  {
    Node n = null;
    Node first = null;


    public void add(K value){
        Node newNode = new Node(null, null, value);
        if(n == null){
            n = newNode;
            first = n;
        }else{
            newNode.prev = n;
            n.next = newNode;
            n = newNode;
        }
    }

    public K peek(){
        return (K)first.element;
    }

    public K poll(){
        K result = (K)first.element;
        if(first.next != null){
            first = first.next;
            first.prev = null;
        }else{
            n = null;
            first = null;
        }
        return result;
    }

    public void clear(){
        n = null;
        first = null;
    }

    public int size(){
        Node check = n;
        int count = 0;
        while (check != null){
            check = check.prev;
            count++;
        }
        return count;
    }
    private class Node<K> {
        K element = null;
        Node<K> next = null;
        Node<K> prev = null;

        Node(Node prElem, Node nextElem, K value) {
            prev = prElem;
            next = nextElem;
            element = value;
        }
    }
}
