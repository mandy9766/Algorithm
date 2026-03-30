package d0213;

import java.io.*;
import java.util.*;

public class SWEA_7206_숫자게임_최태선 {
    static int maxTurnVal;
    static Deque<Integer> deque;
    static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();
        for(int t=0;t<T;t++){
            memo = new int[100000];
            Arrays.fill(memo,-1);
            int N = Integer.parseInt(br.readLine());
            maxTurnVal = 0;
            int ans = Dfs(N);
            System.out.println("#"+(t+1)+" "+ans);
        }
    }
    static int Dfs(int n){
        if(n <10)
            return 0;
        if(memo[n] != -1 ) 
            return memo[n];
        int count = checkCount(n);// count 는 지금 쪼갤수 있는 자리수
        int best =0;
        for(int bit=1;bit<(1<<count);bit++){ // 쪼갤수있는 비트마다
            int product = splitProduct(count,n,bit); //  n을 bit 대로 쪼개서 곱 값을 반환
            best = Math.max(best,1+ Dfs(product));
        }
        memo[n] = best;
        return best;
    }
    static int checkCount(int n){ // 자리수 구하는로직
        int count =0;
        while(n>=10){
            n /= 10;
            count ++;
        }
        return count;
    }
    static int splitProduct(int count, int n,int bit){
        int c= 0;
        int tempC= -1;
        int tempNum;
        int product = 1;
        while (count >c){
            if((bit & 1<<c)!=0){
                int div = (int)Math.pow(10, (c+1));
                if(tempC == -1){
                    tempNum = n%(div);
                    product *= tempNum;
                    tempC = c;
                }else{
                    int div2 = (int)Math.pow(10, (tempC+1));
                    tempNum = (n%(div))/div2;
                    product *= tempNum;
                    tempC = c; 
                }
            }
            c++;
        }
        int div = (int)Math.pow(10,(tempC+1));
        product *= n/div;
        return product;
    }
}
