package org.example.hw9;

public class MyStack<K> {
    Node n = null;

    public void push(K value){
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

    public K peek(){
        return (K)n.element;
    }

    public K pop(){
        K result = (K)n.element;
        n = n.prev;
        n.next = null;
        return result;
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
