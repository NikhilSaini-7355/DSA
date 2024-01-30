package linkedlist;
// using the linkedlist made by us

//import java.util.*;
import linkedlist.LinkedList.linkedlist;
public class LLToStackAdapter2{
    linkedlist list;

    public LLToStackAdapter2()
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
        list.add_first(val);
    }

    public int pop()
    {  if(size()==0)
        {
            System.out.println("empty stack");
            return -1;
        }
        else{
            int h = list.remove_first();
            return h;
        }
   
       
    }

    public  int top()
    {   if(size()==0)
        {
            System.out.println("empty stack");
            return -1;
        }
        else
        {
        int h = list.get_first();
        // or
        //  int h = list.get(list.size()-1);
        return h;
        }
        }

        public static void main(String[] args) {
            LLToStackAdapter2 obj = new LLToStackAdapter2();
            obj.push(8);
            obj.push(9);
            System.out.println(obj.top());
            System.out.println(obj.pop());
            System.out.println(obj.size());
            System.out.println(obj.top());


        }
}
