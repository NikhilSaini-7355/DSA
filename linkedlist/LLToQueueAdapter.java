package linkedlist;
// using the linkedlist made by us

//import java.util.*;
import linkedlist.LinkedList.linkedlist;
public class LLToQueueAdapter {
    linkedlist list;
    public LLToQueueAdapter()
    {
        list = new linkedlist();
    }
    public int size()
    {
        int h = this.list.size();
        return h;
    }
    public void push(int val)
    {
        list.add_last(val);
    }
    public int pop()
    {  if(size==0)
        {
            System.out.println("empty queue");
            return -1;
        }
        else{
            int h = list.remove_first();
            return h;
        }
      
      
    }
    public  int top()
    {   if(size==0)
        {
            System.out.println("empty queue");
            return -1;
        }
        else{
        int h = list.get_first();
        // or
        //  int h = list.get(list.size()-1);
        return h;
        }
        }
        public static void main(String[] args) {
            LLToQueueAdapter obj = new LLToQueueAdapter();
            obj.push(8);
            obj.push(9);
            System.out.println(obj.top());
            System.out.println(obj.pop());
            System.out.println(obj.size());
            System.out.println(obj.top());
        }
}


