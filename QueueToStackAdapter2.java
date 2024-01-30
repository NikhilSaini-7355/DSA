
import java.util.*;
import java.io.*;

// push() efficient
// push() efficient , that is , it happens in O(1) time complexity

public class QueueToStackAdapter2 {
 Queue<Integer> mainQ = new ArrayDeque<Integer>();
 Queue<Integer> helperQ = new ArrayDeque<Integer>();
 public QueueToStackAdapter2()
 {
    mainQ = new ArrayDeque<Integer>();
    helperQ = new ArrayDeque<Integer>();
 }

 public int size()
 {
    return mainQ.size();
 }

 public void push(int n)
 {
    mainQ.add(n);
 }

 public int pop()
 { if(mainQ.size()==0)
    {
        System.out.println("empty stack");
        return -1;
    }

    int t=-1;
   while(mainQ.size()!=0)
   {
     t = mainQ.poll();//Retrieves and removes the head of this queue. This method differs from poll() only in that it throws an exception if this queue is empty.
    if(mainQ.size()!=0)
    {
        helperQ.add(t);
    }
    
}
mainQ = helperQ;
helperQ = new ArrayDeque<>();
return t;
 }

 public int top()
 {
    if(mainQ.size()==0)
    {
        System.out.println("empty stack");
        return -1;
    }

    int t=-1;
   while(mainQ.size()!=0)
   {
     t = mainQ.remove();//Retrieves and removes the head of this queue. This method differs from poll() only in that it throws an exception if this queue is empty.
     helperQ.add(t);
    
    }
mainQ = helperQ;
helperQ = new ArrayDeque<>();
return t;
 }
    

 public void display()
 {
   while (mainQ.size()!=0) {
    int t = mainQ.poll();
    helperQ.add(t);
    System.out.print(t+"--->>>");
}
System.out.println("END");
mainQ = helperQ;
helperQ = new ArrayDeque<>();
 }
 public static void main(String[]args)
 {  System.out.println("fhkh");
    QueueToStackAdapter2 obj = new QueueToStackAdapter2();
    System.out.println("fhdfsfkh");
    obj.push(0);
    obj.push(1);
    obj.push(2);
    obj.push(3);
    obj.push(4);
    obj.push(5);
    obj.push(6);
    obj.display();
    System.out.println(obj.top());
   obj.pop();
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    

    //obj.display();
 }
}
