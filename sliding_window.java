import java.util.*;
public class sliding_window {

    public static void main3()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n]; // stores next greater element on right's index
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        
        // next greater element on the right index
        nge[n-1]=n; st.push(0);
        for(int i=1;i<n-1;i++)
        {
           while (st.size()>0 && a[i]>=a[st.peek()]) {
               nge[st.pop()]=i;            
           }
           st.push(i);
        }
        if(st.size()!=0)
        {
            for(int i=0;i<st.size();i++)
            {
                nge[st.pop()]=n;
            }
        }

        
        for(int j=0;j<=n-4;j++)
        {
            if(nge[j]-j>3)
            {
                st.push(j);
            }
            else
            {   int p =0;
                int l=0; 
                int y =j;
                 while(p<=3)
                 {  p = p+ nge[y]-y;
                    if(p>3)
                    {
                        l = y;
                        break;
                    }
                    y = nge[y];
                 }
                st.push(l);
            }
        }

        for(int g=0;g<st.size();g++)
        {
            System.out.println(a[st.pop()]);
        }
        
    }
}