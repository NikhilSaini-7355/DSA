package linkedlist; // something new for me
// 4-5 questions still left
import java.util.*;

class LinkedList
{   public static class Node
    {
       private int value;
       private Node next;

       public Node(int val)
       {
          value = val;
          
       }
}

public static class linkedlist
{
    Node head;
    Node tail;
    int size;

    
    
    
    public void add_last(int val)
    {
        Node temp = new Node(val);
        temp.next = null;
        if(head!=null)
        {
        tail.next = temp;
        
        tail = temp;
        }
        else
        {
            head = temp;
            tail= temp;
        }
       size++;
    }
    public void display()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.value+"----->>>>");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public int size()
    {
        return this.size;
    }

    public int remove_first()
    {
        int ans = head.value;
        if(size==1)
        {
            head=null;
            tail=null;
            size--;
        }
        else if(size==0)
        {
            System.out.println("empty linkedlist");
        }
        else
        {
            head = head.next;
            size--;
        }
        return ans;
    }
    public int get_first()
    {
        if(size==0)
        {
            
            System.out.println("empty linked list");
            return -1;
        }
        else 
        {
            return head.value;
        }
    }

    public int get_last()
{
    if(size==0)
    {
        System.out.println("empty linked list");
        return -1;
    }
    else 
    {
        return tail.value;
    }
}

public int get_at(int index)
{
    if(size==0)
    {
        System.out.println("empty linked list");
        return -1;
    }
    else if(index>=size || index<0)
    {
        System.out.println("invalid index");
        return -1;
    }
    Node temp = head;
    int i=-1;
    while (temp!=null) {
        i++;
        if(i==index)
        {
            return temp.value;
            
        }
        temp = temp.next;
    }
    return -1;
    
}
public void add_first(int val)
{
    Node temp = new Node(val);
    if(size==0)
    {
        head = temp;
        tail = head;
        temp.next= null;
        size++;
    }
    else
    {
        temp.next = head;
        head = temp;
        size++;
    }
}

public void add_at(int index,int val)
{
    if(index<0 || index>size+1)
    {
        System.out.println("invalid index");
        return;
    }
    Node temp = new Node(val);
    if(index==0 && size==0)
    {
        head = temp;
        tail = temp;
        size++;
    }
    else if(index==0)
    {
        add_first(val);
    }
    else if(index==size)
    {
        add_last(val);
    }
    else
    {
        Node temp2 = head;
        int c=-1;
        while (temp2!=null) {
            c++;
            if(c==index-1)
            {
               temp.next = temp2.next;
               temp2.next = temp;
               size++;
               return;
            }
            temp2 = temp2.next;   
        }
    }
}

public int remove_last()
{  int h;
    if(size==0)
    {
        System.out.println("empty linkedlist");
        return -1;
    }
  
    else if(size==1)
    {
        h = tail.value;
        head = null;
        tail = null;
        
        
    }
    else{
        h = tail.value;
        Node temp = head;
        for(int i=1;i<=size-2;i++)
        {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;

    }
    size--;
    return h;
}

public int remove_at(int index)
{   int h;
    if(index<0 || index>=size)
    {
        
        System.out.println("invalid index");
        return -1;
    }
    else if(size==0)
    {
        
        System.out.println("empty linkedlist");
        return -1;
    }
    
    else if(index==0)
    {
        h= remove_first();
       
    }
    else if(index==size-1)
    {
         h = remove_last();
        
    }
    else
    {
       Node temp = head;
       for(int i=1;i<=index-1;i++)
       {
        temp = temp.next;
       }
        h = temp.next.value;
       temp.next = temp.next.next;
       size--;
       
    }
    return h;
}

public void reverse_data_iterative()
{
  for(int i=0;i<(size/2);i++)
  {
    Node temp = head;
    Node temp2 = head;
    for(int j=0;j<i;j++)
    {
        temp = temp.next;
    }
    for(int h=0;h<size-1-i;h++)
    {
        temp2 = temp2.next;
    }
    int t = temp.value;
    temp.value = temp2.value;
    temp2.value = t;
  }

}
private Node get_Node(int index)
{
    Node temp = head;
    int c=-1;
    while (temp!=null) {
        c++;
        if(c==index)
        {
            break;
        }
        temp = temp.next;
    }

    return temp;
}
public void reverse_data_iterative2()
{
   int li = 0;
   int ri = size-1;
   while (li<ri) {
    Node temp1 = get_Node(li);
    Node temp2 = get_Node(ri);
    int t =  temp1.value;
    temp1.value = temp2.value;
    temp2.value = t;
    li++;
    ri--;

}
}
public int K_element_from_last(int k)
{
    this.reverse_pointer_iterative();
    Node temp = head;
    for(int i=0;i<k;i++)
    {
        temp = temp.next;
    }
    int  h = temp.value;
    this.reverse_pointer_iterative();
    return h;
}

public int K_element_from_last2(int k)
{
    
    Node slow = head;
    Node fast = head;
    for(int i=0;i<k;i++)
    {
        fast = fast.next;
    }
    while(fast!=tail)
    {
        slow = slow.next;
        fast = fast.next;

    }
    int h = slow.value;
    return h;
}

public int midOfLL()
{
    Node slow = head;
    Node fast = head;
    while(fast.next!=null && fast.next.next!=null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    int h = slow.value;
    return h;
}
public void reverse_pointer_iterative()
{
    
    Node temp = head;
    for(int i=size-2;i>=0;i--)
    {
       temp = get_Node(i);
       temp.next.next = temp;
    }
    temp.next = null;
    head = tail;
    tail= temp;
}
public  linkedlist mergeTwoLL(linkedlist obj1,linkedlist obj2)
{
    linkedlist obj3 = new linkedlist();
    Node temp1 = (obj1.head.value>obj2.head.value)?obj1.head:obj2.head;
    Node temp2 = (obj1.head.value<=obj2.head.value)?obj1.head:obj2.head;
    obj3.add_first(temp2.value); temp2 = temp2.next;
    while(temp1!=null || temp2!=null)
    {  if(temp1==null)
        {
            obj3.add_last(temp2.value);
            temp2 = temp2.next;
        }
        else if(temp2==null)
        {
            obj3.add_last(temp1.value);
            temp1 = temp1.next;
        }
        else if(temp1.value<=temp2.value)
        {
            obj3.add_last(temp1.value);
            temp1 = temp1.next;
        }
        else
        {
            obj3.add_last(temp2.value);
            temp2 = temp2.next;
        }

    }
    //obj3.display();
    return obj3;
}
public linkedlist mergesort(Node head,Node tail)
{
   Node temp = this.get_Node((size-1)/2) ; //this.midOfLL();
   linkedlist obj1 = new linkedlist();
   linkedlist obj2 = new linkedlist();
   if(size==1)
   {
    obj1.add_last(head.value);
    //System.out.print("one");
    return obj1;
   }
   else if(temp==head && size==2)
   { //System.out.print("two");
    obj1.add_last(head.value);
    obj2.add_last(tail.value);
    //System.out.print("obj1===");obj1.display();
// System.out.print("obj2===");obj2.display();
    linkedlist obj3 = mergeTwoLL(obj1, obj2);
    //System.out.print("obj3===");obj3.display();
    return obj3;
   }
   else{ //System.out.print("three");
       Node node = head;
       while(node!=temp.next)
       {
        obj1.add_last(node.value);
        node = node.next;
       }
       while (node!=null) {
        obj2.add_last(node.value);
        node = node.next;
       }
       obj1 = obj1.mergesort(obj1.head,obj1.tail);
       obj2 = obj2.mergesort(obj2.head,obj2.tail);
      // System.out.print("obj1===");obj1.display();

     //  System.out.print("obj2===");obj2.display();
       linkedlist obj3 = mergeTwoLL(obj1, obj2);
    //   System.out.print("After obj1===");obj1.display();

      // System.out.print("Aftrer obj2===");obj2.display();
     //  System.out.print("obj3===");obj3.display();
       return obj3;
   }
}

// this keyword is read only
public void remove_duplicates()
{
    linkedlist res = new linkedlist();
    
    while(this.size!=0)
    {   int val = this.get_first();
        this.remove_first();
        if(res.size==0 || res.get_last()!=val)
        {
            res.add_last(val);
        }
    }
    this.head = res.head;
    this.tail = res.tail;
    this.size = res.size;
}
public void oddeven()
{
    linkedlist odd = new linkedlist();
    linkedlist even = new linkedlist();
    while(this.size!=0)
    {   int val = this.get_first();
        this.remove_first();
        if(val%2==0)
        {
            even.add_last(val);

        }
        else{
            odd.add_last(val);
        }
    }
    if(odd.size!=0 && even.size!=0)
    {
        odd.tail.next = even.head;
        this.head = odd.head;
        this.tail = even.tail;
        this.size = odd.size+even.size;
    }
    else if(odd.size!=0)
    {
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;
    }
    else if(even.size!=0)
    {
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size;
    }
}
public void k_reverse(int k)
{
    linkedlist prev = new linkedlist();
    while(this.size>0)
    { linkedlist curr = new linkedlist();
        if(this.size>=k)
        {
            for(int i=0;i<k;i++)
            {
                int val = this.get_first();
                this.remove_first();
                curr.add_first(val);
            }
        }
        else{
            int p=this.size();
            for(int i=0;i<p;i++)
            {
                int val = this.get_first();
                this.remove_first();
                curr.add_last(val);
            }
        }
        if(prev.head == null)
        {
            prev.head = curr.head;
            prev.tail = curr.tail;
            prev.size = curr.size;
        }
        else
        {
            prev.tail.next = curr.head;
            prev.tail = curr.tail;
            prev.size += curr.size;
        }
    }
    this.head = prev.head;
    this.tail = prev.tail;
    this.size = prev.size;
}

public void displayReverse_using_recursion()
{
    displayReverseHelper_using_recursion(this.head);
    System.out.print("END");
    System.out.println();
}

public void displayReverseHelper_using_recursion(Node node)
{
     if(node.next==null)
     {
        System.out.print(node.value+"--->>>");
     }
     else
     {
        displayReverseHelper_using_recursion(node.next);
        System.out.print(node.value+"--->>>");
     }
     
}
// generally doing a operation using recursion , we generally make 2 functions , one the function we call for initiating the recursive call, second the helper function which does the main task and recursively calls itself and after all the recursive calls the flow passes to the function which initially called.

public void reverse_pointer_recursiveHelper(Node node)
{
    if(node.next.next==null)
    {
        node.next.next = node;
    }
    else
    {
        reverse_pointer_recursiveHelper(node.next);
        node.next.next = node;
    }
}
public void reverse_pointer_recursive()
{
   reverse_pointer_recursiveHelper(head);
   head.next = null;
   Node temp;
   temp = head;
   head = tail;
   tail = temp;

}
public void palindrome()
{
    
}
public void reverse_data_recursive_helper()
{
   
}
public void reverse_data_recursive()
{

}
}

    public static void main(String[] args) {
        linkedlist obj = new linkedlist();
        obj.add_last(1); 
        obj.add_last(3);
        obj.add_last(5);
        obj.add_last(501);
        obj.display();
       // obj.remove_first();
       // obj.display();
       // System.out.println("first element="+obj.get_first());
       // obj.add_first(7);
       // System.out.println("first element="+obj.get_first());
       // System.out.println("last element="+obj.get_last());
       // System.out.println("element at index 1="+obj.get_at(1));
    //   System.out.println(obj.get_at(9));
    //  obj.reverse_data_iterative();
    //  obj.display();
    //  obj.reverse_data_iterative2();
    //  obj.display();
    //  obj.reverse_pointer_iterative();
    //  obj.display();
    linkedlist obj2 = new linkedlist();
    obj2.add_last(2); obj2.add_last(0);
    obj2.add_last(101);
    obj2.add_last(1);
    obj2.add_last(7);
    
    obj2.display();
    linkedlist obj3 = obj.mergeTwoLL(obj,obj2);
    obj3.display();
    obj3 = obj3.mergesort(obj3.head,obj3.tail);
    obj3.display();
    obj3.remove_duplicates();
    obj3.display();
    obj3.k_reverse(3);
    obj3.display();
    obj3.displayReverse_using_recursion();
    obj3.display();
    obj3.reverse_pointer_recursive();
    obj3.display();
}
}