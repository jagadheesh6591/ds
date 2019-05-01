package jaga.samp.ds.sortingalgorithms;

import java.util.NoSuchElementException;

public class MyLinkedList {

    Node head = null;

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MyLinkedList mylist = new MyLinkedList();
        mylist.insert(mylist,1);
        mylist.insert(mylist,2);
        mylist.insert(mylist,3);
        mylist.insert(mylist,4);
        mylist.printList(mylist);
        mylist.remove(2);
        mylist.printList(mylist);

    }

    private void remove(int data) {

        if(head==null)
            throw new RuntimeException("Cannot perform operation as list is empty");

        if(head.data == data){
            head = head.next;
            return;
        }

        Node currNode = head.next;
        Node prevNode = head;

        while(currNode!=null && currNode.data != data) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(currNode==null)
            throw new NoSuchElementException();

        prevNode.next = currNode.next;

    }

    private void printList(MyLinkedList mylist) {
        System.out.println();
        Node currNode = mylist.head;
        while(currNode!=null) {
            System.out.print(currNode.data);
            System.out.print(currNode.next!=null?" -> ":"");
            currNode = currNode.next;
        }
    }

    private void insert(MyLinkedList list , int data) {
        Node node = new Node(data);
        if(head==null) {
            head = node;
        } else {
            Node last = list.head;
            while(last.next!=null) {
                last = last.next;
            }
            last.next = node;
        }
    }


}
