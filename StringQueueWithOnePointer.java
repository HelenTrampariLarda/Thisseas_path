
import java.io.PrintStream;
import java.util.*; 


public class StringQueueWithOnePointer {

    public StringQueueWithOnePointer(){}

    private Node last;
    private int count=0;
    Node x = null;
    Node y = null;
    Node oldlast=null;

    public class Node {
        String item; 
        Node next;

        Node(String item ){
            this.item = item; 
            next=null; 
        }    
    }

    public boolean isEmpty(){
        return (last==null);   
    }

    public void put(String item){
        if(!isEmpty()){
            x = new Node(item);
            x.next = last.next; //to epomeno apo to x na einai h arxi tis stoibas
            last.next=x; 
            last=x;
            count+=1;
            
        }else{
            last=new Node(item);
            last.next=last;
            count+=1;
        }
        
    }

    public String get() throws NoSuchElementException{
        if(!isEmpty() && count!=1){
            oldlast=last.next;
            last.next=last.next.next;
            count-=1;
            return oldlast.item; 
        }else if (count==1){
            count-=1;
            oldlast=last;
            last=null;
            return oldlast.item;
        }else{
            throw new NoSuchElementException();
        }
    }

    public String peek() throws NoSuchElementException{
        if(!isEmpty()){
            return last.next.item ;
        }else{
            throw new NoSuchElementException();
        }
    }

    public void printQueue(PrintStream stream){
        if (isEmpty()){
            System.out.println("The queue is empty"); 
        }else{
            if (count==1){
                stream.println(last.item);
            }else{
                y =last.next;
                while (y!=last){
                    stream.println(y.item);
                    y=y.next;
                }
                stream.println(y.item);
            }
        }

    }

    public int size(){
        return count;
    }


/*
    public static void main(String args[] ) {
        StringQueueWithOnePointer s = new StringQueueWithOnePointer();
        s.put("aaa");
        s.put("aaa222");
        s.put("sdf");

        System.out.println("na emfanizei megethos");
        System.out.println(s.size());

        System.out.println("na emfanizei lista");

        PrintStream i = new PrintStream(System.out);

        s.printQueue(i);
        System.out.println("peek ; prepei na bgalei aaa");
        System.out.println(s.get()); 
        System.out.println(s.isEmpty());

        
        System.out.println("peek ; prepei na bgalei aaa22");
        System.out.println(s.get()); 

        System.out.println("peek ; prepei na bgalei sdf");
        System.out.println(s.peek());
        
        System.out.println(s.size());
       
        
    }
*/

}