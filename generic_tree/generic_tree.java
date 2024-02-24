 package generic_tree;
import java.util.*;

class generic_tree {

    public static class Node
{
    int data;
    ArrayList<Node> children = new ArrayList<>();
    public Node(int n)
    {
        data = n;
        children = new ArrayList<>();
    }
    public Node()
    {
        data = 0;
        children = new ArrayList<>();
    }
}    

    public static class GenericTree
    {
        Node root; 
        GenericTree()
        {   root = new Node();
            
        }
        public void constructTree(int[] a)
        {
           if(a[0]==-1)
           {
            System.out.println("empty tree formed");
            return ;
           }

           Stack<Node> b = new Stack<>();
           root.data = a[0];
          // System.out.println(a[0]+" added");
           b.push(root);
           int t = a.length;
          for(int i=1;i<t;i++)
          {
             if(a[i]==-1)
             {
                b.pop();
             }
             else
             {  
                Node node = new Node(a[i]);
              //  System.out.println(b.size()+"--------"+b.peek().data);
                b.peek().children.add(node);
              // System.out.println(a[i]+" added");
                b.push(node);
             }
          }
          return;
        }

public void displayhelper(Node t)
{
   System.out.print(t.data+"-----");
   for(int h=0;h<t.children.size();h++)
   {
    System.out.print(t.children.get(h).data+",");
   }
   System.out.println();
   if(t.children.size()==0)
   {
    return;
   }
   else
   {
    for(int i=0;i<t.children.size();i++)
    {
        displayhelper(t.children.get(i));
    }
   }
}
// understanding the display recursion is very very important
public void display()
{
    displayhelper(this.root);     
}

public int sizehelper(Node t)
{
    if(t.children.size()==0)
    {
        return 0;
    }
    else
    {
        int ans = t.children.size();
        for(Node node:t.children) // for each loop nothing new
        {
            ans += sizehelper(node);
        }

        return ans;
    }
}
public int size()
{
    int ans = sizehelper(root);
    return ans+1; // +1 because root is not counted in above calculation
}
    
public int maxhelper(Node t)
{
    if(t.children.size()==0)
    {
        return t.data;
    }
    else
    {
        int max = t.data;
        for(Node node:t.children)
        {
            int h = maxhelper(node);
            if(h>max)
            {
                max = h;
            }
        }
        return max;
    }
}
public int max()
{
    return maxhelper(root);
    

    // Sir's solution
    // int max = Integer.MIN_VALUE;
    // for(Node child:node.children)
    // {
    //     int cm = max(child);
    //     max = Math.max(max, cm);
    // }
    // max = Math.max(max, node.data);
    // return max;
}
public int heighthelper(Node t)
{
    if(t.children.size()==0)
    {
        return 0;
    }
    else
    {   int max = Integer.MIN_VALUE;
        for(Node node:t.children)
        {
           int h = heighthelper(node);
           if(h>max)
           {
            max = h;
           }
        }
        return 1 + max;
    }
}
public int height()
{
   return heighthelper(root);
}

public void traversalhelper(Node t)
{
    System.out.println("Node pre "+ t.data);
    if(t.children.size()==0)
    {
        System.out.println("Node post "+t.data);
        return;
    }
    else
    {
        for(Node node:t.children)
        {
           System.out.println("Edge pre "+t.data+"--"+node.data);
           traversalhelper(node);
           System.out.println("Edge post"+t.data+"--"+node.data);
        }
        System.out.println("Node post "+t.data);
    }
}
public void traversal()
{
    traversalhelper(root);


    // Sir's logic
    // System.out.println("Node pre "+ node.data);

    // for(Node child:node.children)
    //     {
    //        System.out.println("Edge pre "+node.data+"--"+child.data);
    //        traversal(child);
    //        System.out.println("Edge post"+node.data+"--"+child.data);
    //     }
    //     System.out.println("Node post "+ node.data);
}

// Dry Run this function
public void level_order_traversal_helper(Node t)
{
   
   for(Node node:t.children)
   {
     System.out.print(node.data+"  ");
   }
   for(Node node:t.children)
   {
     level_order_traversal_helper(node);
   }
}
public void level_order_traversal()
{   System.out.print(root.data + "  ");
    level_order_traversal_helper(root);
    System.out.println(" .");

    // Sir's logic -- much better using queues 
    // Queue<Node> q = new ArrayDeque<>();
    // q.add(root);
    // while(q.size()!=0)
    // {
    //     Node a = q.remove();
    //     System.out.print(a.data+"   ");
    //     for(Node node:a.children)
    //     {
    //         q.add(node);
    //     }
    // }
    // System.out.println(" .");
}

public void level_order_traversal_sirlogic()
{
    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    while(q.size()!=0)
    {
        Node a = q.remove();
        System.out.print(a.data+"   ");
        for(Node node:a.children)
        {
            q.add(node);
        }
    }
    System.out.println(" .");
}

public void level_order_linewise()
{
   Queue<Node> parent = new ArrayDeque<>();
   Queue<Node> children = new ArrayDeque<>();
   parent.add(root);
   System.out.println(root.data+"   ");
   while(true)
   {
      int k = parent.size();
      for(int i=0;i<k;i++)
      {  Node node = parent.remove();
        for(int j=0;j<node.children.size();j++)
        {
           children.add(node.children.get(j));
        }
      }
      int h = children.size();
      if(h==0)
      {
        break;
      }
      for(int i=0;i<h;i++)
      {
        Node node = children.remove();
        parent.add(node);
        System.out.print(node.data+"    ");
      }
      System.out.println();
   }

}

public void level_order_linewise_zigzag()
{
    Queue<Node> parent = new ArrayDeque<>();
    Stack<Node> children = new Stack<>();
    parent.add(root);
    System.out.println(root.data+"   ");
    while(true)
    {
       int k = parent.size();
       for(int i=0;i<k;i++)
       {  Node node = parent.remove();
         for(int j=0;j<node.children.size();j++)
         {
            children.push(node.children.get(j));
         }
       }
       int h = children.size();
       if(h==0)
       {
         break;
       }
       for(int i=0;i<h;i++)
       {
         Node node = children.pop();
         parent.add(node);
         System.out.print(node.data+"    ");
       }
       System.out.println();
    }
 
}

public void level_order_linewise2()
{
   Queue<Node> q = new ArrayDeque<>();
   Node NULL = new Node();
   q.add(root);
   q.add(NULL);
   
   while(q.size()!=0)
   {
     Node node = q.remove();
     if(node == NULL )
     {
        if(q.size()!=0)
        {   
            q.add(NULL);
            System.out.println();
        }
     }
     else
     {
        System.out.print(node.data +"   ");
        for(Node temp:node.children)
        {
            q.add(temp);
        }
     }
   }
  System.out.println();

   }

public void level_order_linewise3()
{
   Queue<Node> q = new ArrayDeque<>();
   q.add(root);
   while(q.size()!=0)
   {
      int size = q.size();
      for(int i=0;i<size;i++)
      {
        Node node = q.remove();
        System.out.print(node.data+"  ");
        for(Node temp:node.children)
        {
            q.add(temp);
        }
      }
      System.out.println();
   }
   }

   private static class pair
   {
     Node node;
     int level;
     pair(Node node,int level)
     {
        this.node = node;
        this.level = level;
     }

   }
  
   int level =1 ;
public void level_order_linewise4()
{
   Queue<pair> q = new ArrayDeque<>();
   q.add(new pair(root,1));
   while(q.size()!=0)
   {
      pair p = q.remove();
      if(p.level>level)
      {
        level = p.level;
        System.out.println();
      }
      System.out.print(p.node.data+"   ");
      for(Node temp:p.node.children)
      {
        q.add(new  pair(temp,level+1));
      }
   }
}

public void mirror_display()
{
    // Queue<Node> q = new ArrayDeque<>();
    Queue<Node> q = new ArrayDeque<>();
    Stack<Node> a = new Stack<>();
    q.add(root);
    // int size = q.size();
    while(q.size()!=0)
    {
        int size = q.size();
        for(int i=0;i<size;i++)
        {   Node node = q.remove();
            a.push(node);
            for(Node temp:node.children)
            {
                q.add(temp);
            }
        }

        int size2 = a.size();
        for(int i=0;i<size2;i++)
        {
           System.out.print(a.pop().data+"  ");
        }
        System.out.println();
    }
    System.out.println();
}

public void mirror_sir_logic_helper(Node node)
{ for(Node child:node.children)
    {
        mirror_sir_logic_helper(child);
    }
   Collections.reverse(node.children);
}

public void mirror_sir_logic()
{
    mirror_sir_logic_helper(root);
}

public boolean remove_leave_helper(Node node)
{
   if(node.children.size()==0)
   {  // System.out.println("remove"+ node.data);
    return false;
   }
   else
   { 
    for(int i=0;i<node.children.size();i++)  // this loop is giving ConcurrentModificationException when " Node temp:node.children " is used in for loop brackets
    {   // System.out.println("size has"+ node.data + "   "+ node.children.size());
        Node temp = node.children.get(i);
        boolean bb = remove_leave_helper(temp);
        if(bb==false)
        {
            node.children.remove(temp);
            i--;   // this statement was added with some really smart thohtprocess and brains applied 
        }
    }
    return true;
   }
}
public void remove_leaves()
{   if(root.children.size()!=0)
    remove_leave_helper(root);
}


public void remove_leaves_sir_logic(Node node)
{   // preorder operation is important 
    // this is very important 
    for(int i=node.children.size()-1;i>=0;i--)
    {
        Node child = node.children.get(i);
        if(child.children.size()==0)
        {
            node.children.remove(child);
        }
    }
    
    // this is where the recurson happens
    for(Node child:node.children)
    {
        remove_leaves_sir_logic(child);
    }
}

public void linearize(Node node)
{
    for(Node child: node.children)
    {
        linearize(child);
    }
    
}
}

public static void main(String[] args)
{
    GenericTree obj = new GenericTree();
    
    int[] a = {110,2,-1,67,70,56,34,-1,-1,-1,-1,3,4,5,-1,6,8,9,-1,-1,-1,7,-1,-1,-1,-1};
    obj.constructTree(a);
    obj.display();
    //System.out.println(obj.size());
    //System.out.println(obj.max());
   //System.out.println(obj.height());
    // obj.traversal();
    // obj.level_order_traversal();
    // obj.level_order_traversal_sirlogic();
    // obj.level_order_linewise();
    // obj.level_order_linewise2();
    // obj.level_order_linewise3();
    // obj.level_order_linewise4();
   // obj.level_order_linewise_zigzag();
   // obj.mirror_display();
   obj.remove_leaves();
   // obj.remove_leaves_sir_logic(obj.root);
   obj.display();
}

}