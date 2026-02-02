package d0202;

import java.io.*;
import java.util.*;
public class BJ_21921_블로그_최태선 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        int sum = 0;
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0;i<X;i++){
            sum += arr[i];
        }
        int maxVal = sum;
        int count = 1;
        for(int i=X;i<N;i++){
            sum -= arr[i-X];
            sum += arr[i];
            if(sum > maxVal){
                count = 1;
                maxVal = sum;
            }else if (sum == maxVal){
                count ++;
            }
        }
        if(maxVal == 0){
            System.out.println("SAD");
        }else{
            System.out.println(maxVal);
            System.out.println(count);
        }
    }
}
