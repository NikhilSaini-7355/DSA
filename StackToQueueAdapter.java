import java.util.*;
import java.io.*;

// remove() is made efficient , i.e, it run in O(1) time complexity

public class StackToQueueAdapter<T> {
  Stack<T> mainS = new Stack<>(); // here I am trying to learn Generic applications in Java hence used T , to denote any general Datatype
  Stack<T> helperS = new Stack<>();
 
  public StackToQueueAdapter()
  {
    mainS = new Stack<>();
    helperS = new Stack<>();
  }
  public int size()
  {
    return mainS.size();
  }

  public void add(T n)
  {
     while(mainS.size()!=0)
     {
        helperS.push(mainS.pop());
     }

     mainS.push(n);
     while(helperS.size()!=0)
     {
        mainS.push(helperS.pop());
     }
  }

  public T remove()
  { if(mainS.size()==0)
    {
        System.out.println("empty Queue");
        return null;
    }
    return mainS.pop();
  }

  public T  peek()
  {  if(mainS.size()==0)
    {
        System.out.println("empty Queue");
        return null;
    }
     return mainS.peek();
  }

  public void display()
  {
    while (mainS.size()!=0) {
        T t = mainS.pop();
        helperS.push(t);
       System.out.print(t+"--->>>"); 
    }

    System.out.println("END");
    while(helperS.size()!=0)
     {
        mainS.push(helperS.pop());
     }
  }
  
    public static void main(String[] args) {
        StackToQueueAdapter<Integer> obj = new StackToQueueAdapter<>();
        obj.add(0);
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.display();
        System.out.println(obj.remove());
        System.out.println(obj.peek());
        System.out.println(obj.size());
        obj.add(7);
        obj.display();
    
  }
}
