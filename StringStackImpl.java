import java.io.*;
import java.util.*; 

public class StringStackImpl implements StringStack {

    private Node head;
    private int counter=0;


    public StringStackImpl () {}

    public class Node {
        String item; 
        Node next;

        Node(String item, Node next) {
            this.item = item; 
            this.next = next; 
        }    
    }
    
    public boolean isEmpty(){
        return head==null; 
    }

    public void push(String item){
        head = new Node(item, head);
        counter+=1;
    }

    public String pop() throws NoSuchElementException{
        if (!isEmpty()) { 
           String v = head.item;
           Node t = head.next;
           head=t;
           counter-=1;
           return v;
        } 
        else{
            throw new NoSuchElementException();
        } 
    }

    public String peek() throws NoSuchElementException{
        if (!isEmpty()){
            return head.item;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public void printStack(PrintStream stream){
        if (isEmpty()){
            System.out.println("The stack is empty"); 
        }else{
            Node t= head;
            while (t!=null){
                stream.println(t.item);
                t =t.next;
            }
        }
    }

    public int size(){ 
        return counter;
    }
/*
    public static void main(String args[] ) {
        StringStackImpl s = new StringStackImpl();
        s.push("aaa");
        s.push("bbb");
        s.push("ccc");

        PrintStream i = new PrintStream(System.out);

        s.printStack(i);

        System.out.println("proto stoixeio");
        System.out.println(s.pop());

        System.out.println("peek ; prepei na bgalei bbb");
        System.out.println(s.peek());

        System.out.println(s.size());

    }
*/

}
