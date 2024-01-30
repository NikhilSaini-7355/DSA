package linkedlist;
// using the linkedlist provided by java
import java.util.LinkedList;
import java.util.*;

public class LLToStackAdaapter {
    LinkedList<Integer> list;

    public LLToStackAdaapter()
    {
        list = new LinkedList<>();
    }

    public int size()
    {
        int h = this.list.size();
        return h;
    }

    public void push(int val)
    {
        list.add(val);
    }

    public int pop()
    {
       int h = list.removeLast();
       return h;
    }

    public  int top()
    {
        int h = list.peekLast();
        // or
        //  int h = list.get(list.size()-1);
        return h;
        }
}
