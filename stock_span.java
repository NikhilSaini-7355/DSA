// this one is for stock span
import java.util.*;
public class stock_span
{
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        // next greatest element to the left diff 
        System.out.println("enter value of n");
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        
        Stack<Integer> st = new Stack<>();
        st.push(a.length-1);
        int[] gel = new int[n];
        gel[0] = 1;
        for(int i=a.length-2;i>=1;i--)
        {
            while(st.size()>0 && a[i]>a[st.peek()])
            {
                gel[st.peek()] = st.peek() - i;
                st.pop();
            }
            st.push(i);
        }
       while(st.size()>0)
       {
        gel[st.peek()] = -1;
        st.pop();
       }
    }
}