package org.lig.algorithm;

public class DoubleLinkedListReverser {

    public static MyNode reverse(MyNode head){

        MyNode pre = null ;
        MyNode next = null;

        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            head.setPrev(next);

            pre=head;
            head=next;

        }

        return pre;
    }

}
class MyNode<E>{


    private MyNode prev;
    private MyNode next;
    private E data;

    public MyNode(E data){
        this.data=data;
    }

    public MyNode(MyNode<E> prev, MyNode<E> next, E data){
        this.prev=prev;
        this.next=next;
        this.data=data;
    }

    public MyNode getPrev() {
        return prev;
    }

    public MyNode setPrev(MyNode prev) {
        this.prev = prev;
        return this;
    }

    public MyNode getNext() {
        return next;
    }

    public MyNode setNext(MyNode next) {
        this.next = next;
        return this;
    }

    public E getData() {
        return data;
    }

    public MyNode setData(E data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "value="+this.data;
    }
}
