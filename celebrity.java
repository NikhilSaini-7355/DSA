import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class celebrity {
    public static void main(String[]args)
{   String s = "3+4/4*8-9*1";
    char ch;
    Stack<String> st = new Stack<>();
    
    for(int i=0;i<s.length();i++)
    {
        ch = s.charAt(i);
        if(ch=='*' || ch=='/')
        {
            int a = Integer.parseInt(st.pop());
            int b = Integer.parseInt(s.charAt(i+1)+"");
            int d = (ch=='*')?(a*b):(a/b);
            st.push(""+d);
            i++;
        }
        else
        {
            st.push(""+ch);
        }
    }
System.out.println(st);
int h = st.size(); 
    while (st.size()!=1)
{    String s1 = st.pop();
    String s2 = st.pop();
    
    if(s2.equals("+")|| s2.equals("-"))
    {
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(st.pop());
        int d = (s2.equals("+"))?(a+b):(b-a);
        st.push(""+d);
    }
}
int b = Integer.parseInt(st.pop());
System.out.println(b);

}
}
