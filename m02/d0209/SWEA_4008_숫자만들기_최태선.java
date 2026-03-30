package d0209;

import java.io.*;
import java.util.*;


public class SWEA_4008_숫자만들기_최태선 {
    static int[] op;// + - * /
    static int[] nums;
    static int maxVal;
    static int minVal;
    static int[] opOrder;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            op = new int[4];
            for(int k=0;k<4;k++){
                op[k] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            nums = new int[N];
            for(int k=0;k<N;k++){
                nums[k] = Integer.parseInt(st.nextToken());
            }
            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;
            opOrder = new int[N-1];
            Perm(0);
            sb.append("#").append(t+1).append(" ").append(maxVal-minVal).append("\n");
        }
        System.out.println(sb);
    }

    static void Perm(int depth){
        if (depth == N-1){
            check();// 값 구해서 min값이랑 max값이랑 비교해서 넣기
            return;
        }
        for(int k=0;k<4;k++){
            if(op[k] != 0){
                op[k] --;

                opOrder[depth] = k; // k번째 연산자 넣기
                Perm(depth+1);
                op[k] ++;
            }
        }

    }
    static void check(){
        int nowNum = nums[0];
        for(int i=0;i<N-1;i++){
            switch (opOrder[i]) {
                case 0:
                    nowNum = nowNum + nums[i+1]; 
                    break;
                case 1:
                    nowNum = nowNum - nums[i+1]; 
                    break;
                case 2:
                    nowNum = nowNum * nums[i+1]; 
                    break;
                case 3:
                    nowNum = nowNum / nums[i+1]; 
                    break;
                default:
                    break;
            }
        }
        minVal = Math.min(minVal,nowNum);
        maxVal = Math.max(maxVal,nowNum);
    }
}
