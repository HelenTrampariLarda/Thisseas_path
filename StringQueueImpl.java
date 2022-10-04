import java.io.PrintStream;
import java.util.*; 
import java.lang.Object;


public class StringQueueImpl implements StringQueue {

    private Node first;
    private Node last;
    private int counter=0;

    public StringQueueImpl (){}

    public class Node {
        String item; 
        Node next;

        Node(String item) {
            this.item = item; 
            next=null; 
        }    
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void put(String item){
        Node t = last;
        last = new Node(item) ;
        if (isEmpty()){
            first=last;
        }else{
            t.next = last;
        }
        counter+=1;
         
    }

    public String get() throws NoSuchElementException{
        if (!isEmpty()){
            Node t = first;
            first = t.next;
            counter-=1;
            return t.item;
        }else{
            throw new NoSuchElementException();
        }
    }

    public String peek() throws NoSuchElementException{
        if (!isEmpty()){
            return first.item;
        }else{
            throw new NoSuchElementException();
        }
    }

	public void printQueue(PrintStream stream){
        if (isEmpty()){
            System.out.println("The queue is empty"); 
        }else{
            Node x =first; 
            while (x!=null){
                stream.println(x.item);
                x=x.next;
            }
        }
    }

    public int size(){ 
        return counter;
    }

/*
    public static void main(String args[] ) {
        StringQueueImpl s = new StringQueueImpl();
        s.put("aaa");
        s.put("bbb");
        s.put("ccc");
        PrintStream i = new PrintStream(System.out);

        s.printQueue(i);

        System.out.println("proto stoixeio");
        System.out.println(s.get());

        System.out.println("peek ; prepei na bgalei bbb");
        System.out.println(s.peek());

        System.out.println(s.size());

    }
    */

}

