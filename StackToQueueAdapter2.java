import java.util.*;
import java.io.*;

// add() is made efficient , i.e, it runs in O(1) time complexity

public class StackToQueueAdapter2<T> {
  Stack<T> mainS = new Stack<>(); // here I am trying to learn Generic applications in Java hence used T , to denote any general Datatype
  Stack<T> helperS = new Stack<>();
 
  public StackToQueueAdapter2()
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
     mainS.push(n);
  }

  public T remove()
  { T t;
    while(mainS.size()!=0)
    {
        t = mainS.pop();
        if(mainS.size()!=0)
        {
            helperS.push(t);
        }
    }
    mainS = helperS;
    helperS = new Stack<>();
    return t;
  }

  public T  peek()
  { T t;
    while(mainS.size()!=0)
    {
        t = mainS.pop();
        
            helperS.push(t);
        
    }
    mainS = helperS;
    helperS = new Stack<>();
    return t;
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
        StackToQueueAdapter2<Integer> obj = new StackToQueueAdapter2<>();
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
