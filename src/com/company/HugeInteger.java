package com.company;

/*
Evgeniya Zhukova
ID: 101239316
Feb 14, 2020
*/

import static java.lang.Integer.parseInt;

public class HugeInteger {

    // declaration of variables
    private boolean isPositive;
    private Node head;
    private Node tail;
    private int length;

    //constructor for creation an empty linked list
    public HugeInteger() {
        this.isPositive = true;
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    //constructor for creation a doubly linked list
    public HugeInteger(String number) {

        //assigning value to variables
        this.head = null;
        this.tail = null;
        this.length = 0;

        //checking if number is negative
        if (number.charAt(0) == '-') {
            this.isPositive = false;
            //deleting "-" from String if number is negative
            number = number.replaceFirst("-", "");
        } else
            this.isPositive = true;

        //removing all leading zeros (0)
        number = number.replaceFirst("^0*", "");

        //converting string to array of strings
        String[] numberToArray = number.split("");

        //converting each string from array into integers
        //save each integer as data for individual node
        for (String i : numberToArray) {
            Node newNode = new Node(parseInt(i));

            //if linked list is empty, assign newNode as head and tail of list
            if (head == null) {
                head = newNode;
                tail = newNode;
            //linking newNode to head in order to write number in list in reverse order
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;         //assigning newNode as head
            }
            length++;
        }
    }

    public HugeInteger addPositive(HugeInteger num2) {
        //receiving toString() value of linked lists
        //deleting "-" if numbers are negative
        //converting numbers from String to integer
        int thisValue = parseInt(this.toString().replaceFirst("-", ""));
        int num2Value = parseInt(num2.toString().replaceFirst("-", ""));

        //summarizing integer values of numbers
        int sum = thisValue + num2Value;

        //converting integer to String and use it as data for new HugeInteger
        return new HugeInteger(Integer.toString(sum));
    }

    public int compareTo(HugeInteger num2) {
        //receiving toString() value of linked lists
        //converting numbers from String to long integer
        long thisValueInt = Long.parseLong(this.toString());
        long num2ValueInt = Long.parseLong(num2.toString());

        //comparing values
        return Long.compare(thisValueInt, num2ValueInt);
    }

    public String toString(){
        String printStr = "";
        //printing starts from tail, because number was stored in reverse view
        Node curr=tail;

        //if list is empty, print 0
        if (curr==null){
            printStr = length + "";
        //print "-", if number is negative
        } else{
            if (!this.isPositive){
                printStr +="-";
            }
        //print all data values in order from tail to head
            while (curr!=null){
                printStr += curr.data;
                curr=curr.prev;
            }
        }
        return printStr;
    }

    public void concatenateDigit(int digit) {
        //creating new node for digit
        Node newNode = new Node(digit);
        //if linked list is empty and digit is not 0, assign newNode as head and tail of list
        if (head == null && newNode.data != 0) {
            head = newNode;
            tail = newNode;
            length++;
            //linking newNode to head in order to write number in list in reverse order
        } else if (head != null){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;         //assigning newNode as head
            length++;
        }
    }

    public void addLast(int digit) {
        //creating new node for digit
        Node newNode = new Node(digit);
        //if linked list is empty, assign newNode as head and tail of list
        if(tail == null){
            head = newNode;
            tail = newNode;
            length++;
            //linking newNode to tail in order to add a digit
            // to the front of the number (at the end of the list)
        } else
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;         //assigning newNode as tail
            length++;
    }
}