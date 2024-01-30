import java.util.*;
// My solution(method 2)
// public class test{
    // public static void main(String[]args)
    // {
       // solves next greater element to the right
        // System.out.println("enter n");
        // int n;
        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        // int a[] = new int[n];
        // for(int i=0;i<n;i++)
        // {
            // a[i] = sc.nextInt();
        // }
        // 
        // Stack<Integer> st = new Stack<>();
        // st.push(a[0]);
        // for(int i=1;i<n;i++)
        // {
            // while( st.size()!=0)
            // {   if(a[i]>st.peek())
                // {
                // int h = st.pop();
                // System.out.println("next greater element for "+ h+ " is "+ a[i]);
                // }
                // else
                // {
                    // break;
                // }
            // }
// 
            // st.push(a[i]);
// 
// 
        // }
        // int k = st.size();
        // for(int j=0;j<k;j++)
        // {
        //   int h2 = st.pop();
        // System.out.println("next greater element for "+ h2+ " is "+ -1);
        // }
        // System.out.println(st);
    // }
// }
// 
// Sir Solution (method 1)
public class test{
    public static void main(String[]args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         System.out.println("enter n");
         int n;
         n = sc.nextInt();
int a[] = new int[n];
for(int i=0;i<n;i++)
{
    a[i] = sc.nextInt();
    }

    int[] b = solve(a);
    for(int j=0;j<n;j++)
    {
        System.out.println("next greater of "+a[j] +"is " + b[j]);
    }
}

public static int[] solve(int[] arr)
{
    int c[] = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(arr[arr.length-1]);
    c[arr.length-1] = -1;
    for(int i=arr.length-2;i>=0;i--)
    {
        while(st.size()>0 && arr[i]>=st.peek())
        {
            st.pop();
        }
        if(st.size()==0)
        {
            c[i] = -1;
        }
        else{
            c[i] = st.peek();
        }

        st.push(arr[i]);
    }

    return c;

}
}
