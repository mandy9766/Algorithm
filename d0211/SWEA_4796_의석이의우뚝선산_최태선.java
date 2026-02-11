package d0211;

import java.util.*;

public class SWEA_4796_의석이의우뚝선산_최태선 {
    static int N;
    static int[] h;
    static int up,down;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t =0;t<T;t++){
            N = sc.nextInt();
            h = new int[N];
            for(int i=0;i<N;i++){
                h[i] = sc.nextInt();
            }
            int sum = 0;
            up = 0;
            down = 0;
            for(int i=0;i<N-1;i++){
                if (h[i] > h[i+1]){ // 내려가는경우
                    if(up == 0){
                        continue;
                    }
                    else{
                            down ++;
                    }
                }
                else{
                    if(down != 0){
                        sum += up * down;
                        up = 1;
                        down = 0; 
                    }
                    else{
                        up ++;
                    }
                }
            }
            sum += up*down;
            System.out.println("#"+(t+1) +" " +sum);
        }
        sc.close();
    }
}
