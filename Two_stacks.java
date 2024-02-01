import java.util.*;
import java.io.*;
public class Two_stacks {
    
    int[] a;
    int ptr1;
    int ptr2;
    Two_stacks(int n)
    {
        a = new int[n];
        ptr1 = -1;
        ptr2 = n;
    }

    public void push1(int t)
    {
        if(ptr1+1>=ptr2)
        {
            System.out.println("stack1 overflow");
            return ;
        }
        else
        {
            ptr1++;
            a[ptr1] = t ;
        }
    }

    public void push2(int t)
    {
        if(ptr1>=ptr2-1)
        {
            System.out.println("stack2 overflow");
            return ;
        }
        else
        {
            ptr2--;
            a[ptr2]=t;
        }
    }

    public int size1()
    {
        return ptr1+1;
    }

    public int size2()
    {
        return a.length-ptr2;
    }

    public int peek1()
    {
        if(ptr1==-1)
        {
            System.out.println("stack1 underflow");
            return -1;
        }
        else
        {
            return a[ptr1];
        }
    }

    
    public int peek2()
    {
        if(ptr2==a.length)
        {
            System.out.println("stack2 underflow");
            return -1;
        }
        else
        {
            return a[ptr2];
        }
    }

    public int pop1()
    {
        if(ptr1==-1)
        {
            System.out.println("stack1 underflow");
            return -1;
        }
        else
        {
           return a[ptr1--];
        }
    }

    public int pop2()
    {
        if(ptr2==a.length)
        {
            System.out.println("stack2 underflow");
            return -1;
        }
        else
        {
           return a[ptr2++];
        }
    }
 public void display1()
 {
   for(int i=0;i<=ptr1;i++)
   {
     System.out.print(a[i]+"--->>>");

   }
   System.out.println("END");
 }

 public void display2()
 {
   for(int i=a.length-1;i>=ptr2;i--)
   {
     System.out.print(a[i]+"--->>>");

   }
   System.out.println("END");
 }
    public static void main(String[]args)
    {
        Two_stacks obj = new Two_stacks(10);
        obj.push1(1);
        obj.push1(1);
        obj.push1(1);
        obj.push1(1);
        obj.push2(2);
        obj.push2(2);
        obj.push2(2);
        obj.push2(2);
        obj.push2(2);
        obj.push2(2);
        obj.pop2();
        obj.push2(7);
        obj.pop1();
        System.out.println(obj.size1());
        System.out.println(obj.size2());
        obj.display1();
        obj.display2();
    }
}
