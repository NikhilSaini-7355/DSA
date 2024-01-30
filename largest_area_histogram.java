import java.util.*;
 class largest_area_histogram
{
   
// MY SOLUTION
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int[] a = new int[n];
//    int[] b = new int[n];
//    Stack<Integer> st = new Stack<>();
//    int i;
//    for(i=0;i<n;i++)
//    {
//        a[i] = sc.nextInt();
//        b[i] = a[i];
//        
//    }
//    Arrays.sort(b);
//    int area=0; int maxArea=0; int w1=0,w2=0;
//    for(int j=0;j<b.length;j++)
//    {
//        for(int k=0;k<a.length;k++)
//        {
//            if(a[k]>=b[j])
//            {   w1++;
//                st.push(a[k]);
//            }
//            else
//            {   if(w1>w2)
//                {
//                    w2=w1;
//                }
//                st.clear();
//                w1=0;
//            }
//        }
//       area = (w2!=0)?b[j]*w2:b[j]*st.size();
//       st.clear();
//       w2=0;w1=0;
//       System.out.println(area);
//        if(area>maxArea)
//        {
//            maxArea = area;
//        }
//    }
//    System.out.println("maxArea is"+maxArea);
//}






// SIR SOLUTION
public static void main2(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
int i;
for(i=0;i<n;i++)
{
    a[i] = sc.nextInt();
}

int rb[] = new int[n]; // right boundary index, found by next lesser element on the right
Stack<Integer> st = new Stack<>();
rb[n-1] = n; st.push(0); // filling index
for(i=1;i<n-1;i++)
{
   while(st.size()>0 && a[i]<a[st.peek()])
   {
    rb[st.pop()]=i;
   }
   st.push(i);
}
if(st.size()!=0)
{
    for(i=0;i<st.size();i++)
    {
        rb[st.pop()]=n;
    }
}
int lb[] = new int[n]; // left boundary index, found by next lesser element on the left
lb[0]=-1;st.push(n-1);

for(i=n-2;i>0;i--)
{
   while(st.size()>0 && a[i]<a[st.peek()])
   {
    lb[st.pop()]=i;
   }
   st.push(i);
}

if(st.size()!=0)
{
    for(i=0;i<st.size();i++)
    {
        lb[st.pop()]=-1;
    }
}

int maxArea = 0;
for(int j=0;j<n;j++)
{
    int area = a[j]*(rb[j]-lb[j]-1);
    if(area>maxArea)
    {
        maxArea = area;
    }
}

System.out.println(maxArea);
}
}