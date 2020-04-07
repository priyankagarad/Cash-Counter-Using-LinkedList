package com.cashcounter.linkedlist;
import java.util.Scanner;
public class LinkedList
{
    class Node                              //created node
    {
        int data;
        Node next;

        Node(int data)                    //created constructor and pass value to data
        {
            data = data;
            next = null;
        }
    }
    int size;
    public Node head=null;
    public Node tail=null;
    public void addNodeAtEnding(int data)       //add node from end position
    {
        Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        Node current=head;
        while(current.next!=null)
        {
            current = current.next;
        }
            current.next=newnode;
        }
        public void addNodeAtAnyPosition(int data,int position)   //add node at any position
        {
            Node newnode=new Node(data);
            if(head==null)
            {
                head=newnode;
                tail=newnode;
            }
            Node previous=head;
            int count=1;
            while(count<position-1)
            {
                previous=previous.next;
                count++;
            }
            Node current=previous.next;
            newnode.next=current;
            previous.next=newnode;
        }
        public void deleteNodeAtStartPosition()              //delete node from start position
        {
            if (head == null)
            {
                return;
            }
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
        public void display()                                    //display node
        {
            Node current=head;
            if(head==null)
            {
                System.out.println("linked list is empty");
            }
            while(current!=null)
            {
                System.out.println(current.data);
                current=current.next;
            }
        }
        public static void main(String args[])            // main method
        {
            System.out.println("welcome to Banking Cash Counter");
            /*
            created object of stack class for accessing method of class
            scanner class object created for taking value from user
            1.first ask how many people in line for cash withdraw or deposit
            2.then select choice if user want to 0)Deposit money then press 0
                                                  1)Withdraw money then press 1
            */
        Bank bank = new Bank();
        LinkedList list=new LinkedList();

        Scanner sc = new Scanner(System.in);
        System.out.println("how many people in queue");
        int peopleCount = sc.nextInt();

        while (peopleCount > 0) {
            peopleCount--;
            System.out.println("enter amount user want");
            int amountWant = sc.nextInt();

            System.out.println("ask for choice");
            System.out.println("0.Deposit money");
            System.out.println("1.withdraw money");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    list.addNodeAtEnding(peopleCount);
                    bank.depositAmount(amountWant);
                    list.deleteNodeAtStartPosition();
                    break;
                case 1:
                    list.addNodeAtEnding(peopleCount);
                    bank.withdraw(amountWant);
                    list.deleteNodeAtStartPosition();
                    break;
                default:
                    System.out.println("invalid option");
            }
        }
    }
}







