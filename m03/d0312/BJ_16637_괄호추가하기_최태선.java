package d0312;

import java.io.*;
import java.util.*;

public class BJ_16637_괄호추가하기_최태선 {
    static int N;
    static int[] numbers;
    static char[] ops;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] temp = br.readLine().toCharArray();
        numbers = new int[N/2+1];
        ops = new char[N/2]; // N/2 이상이면 ops없음
        for(int i=0;i<N;i++){
            if(i%2 == 0){
                numbers[i/2] = temp[i]-'0';
            }else{
                ops[i/2] = temp[i];
            }
        }
        maxVal = Integer.MIN_VALUE;
        dfs(0,numbers[0]);
        System.out.println(maxVal);
    }
    static void dfs(int depth,int total){ // depth는 이번거 선택할건지
        if(depth>=N/2){
            maxVal = Math.max(maxVal,total);
            return;
        }
        // 다음연산자에 괄호
        if(depth < N/2-1){
            int tempTotal = calc(numbers[depth+1],numbers[depth+2],ops[depth+1]);
            int selectNextTotal = calc(total,tempTotal,ops[depth]);
            dfs(depth+2,selectNextTotal);
        }
        // 다음연산자 괄호 안함
        dfs(depth+1,calc(total,numbers[depth+1],ops[depth]));
    }
    // 사칙연산을 처리해줄 헬퍼 함수
    static int calc(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b; // '*' 인 경우
    }
}
