
import java.util.*;
import java.io.*;

// pop() and top() efficient
// pop() and top() efficient , that is , it happens in O(1) time complexity

public class QueueToStackAdapter {
 Queue<Integer> mainQ = new ArrayDeque<Integer>();
 Queue<Integer> helperQ = new ArrayDeque<Integer>();
 public QueueToStackAdapter()
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
    helperQ = mainQ;
    mainQ = new ArrayDeque<Integer>();
    mainQ.add(n);
    while (helperQ.size()!=0) {
      mainQ.add(helperQ.poll());
    }

 }

 public int pop()
 {  if(mainQ.size()==0)
   {
       System.out.println("empty stack");
       return -1;
   }
   return mainQ.poll();
 }

 public int top()
 {  if(mainQ.size()==0)
   {
       System.out.println("empty stack");
       return -1;
   }
    return mainQ.peek();
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

 }
 public static void main(String[]args)
 {  System.out.println("fhkh");
    QueueToStackAdapter obj = new QueueToStackAdapter();
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
