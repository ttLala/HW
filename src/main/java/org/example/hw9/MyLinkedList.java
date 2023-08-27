package org.example.hw9;


public class MyLinkedList<K> {
    Node n = null;
    public void add(K value){
        Node newNode = new Node(null, null, value);
        if(n == null){
            n = newNode;
        }else{
            newNode.prev = n;
            n.next = newNode;
            n = newNode;
        }
    }
    public void remove(int index){
        int size = this.size();
        if(index == size - 1){
            n = n.prev;
            n.next = null;
            return;
        }
        Node check = n;
        while (size > index + 1){
            check = check.prev;
            size--;
        }
        if (check.prev == null){
            check.next.prev = null;
            return;
        }
        check.prev.next = check.next;
        check.next.prev = check.prev;
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
    public void clear(){
        n = null;
    }
    public K get(int index){
        int size = this.size();
        if(index < 0 || index >= size){
            return null;
        }
        Node check = n;
        while (size != index + 1){
            check = check.prev;
            size--;
        }
        return (K)check.element;
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



