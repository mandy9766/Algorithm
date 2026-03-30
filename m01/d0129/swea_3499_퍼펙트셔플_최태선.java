package d0129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class swea_3499_퍼펙트셔플_최태선{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Stack<String> result = new Stack<>();
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int leftCount = (n+1)/2;
            int rightCount = n-leftCount;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<leftCount;i++){   
                    s1.add(st.nextToken());
            }
            for(int i=0;i<rightCount;i++){   
                    s2.add(st.nextToken());
            }
            if(n%2 == 1){
                result.add(s1.pop());
                for(int i=0;i<n/2;i++){
                    result.add(s2.pop());
                    result.add(s1.pop());
                }
            }
            else{
                for(int i=0;i<n/2;i++){
                    result.add(s2.pop());
                    result.add(s1.pop());
                }
            }
            while(!result.isEmpty()){
                sb.append((result.pop()+" "));
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println("#"+(t+1) +" " + sb);
        }
    }
}