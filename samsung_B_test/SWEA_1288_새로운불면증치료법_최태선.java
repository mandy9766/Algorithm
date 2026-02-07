package samsung_B_test;
import java.util.*;
import java.io.*;
public class SWEA_1288_새로운불면증치료법_최태선 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int total = (1<<10)-1;
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int visited = 0;
            int nowVal = N;
            while (true){
                char[] c = Integer.toString(nowVal).toCharArray();
                for (char nowC : c) {
                    int num = nowC - '0'; 
                    visited |= (1<<num);
                }
                if(total == visited){
                    break;
                }
                nowVal += N;
            }
            System.out.println("#"+(t+1) + " " +nowVal);
        }
    }
}
