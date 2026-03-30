package d0212;

import java.io.*;
import java.util.*;


public class SWEA_14510_나무높이_최태선R {
    static int N;
    static int[] trees;
    static int day;
    static int maxHeight;
    static int totalDiff;
    static int odd,even;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            maxHeight = 0;
            odd = 0;
            even = 0;
            day =0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }
            totalDiff =0;
            for(int i=0;i<N;i++){
                trees[i] = maxHeight - trees[i];
                totalDiff+= trees[i];
                odd += trees[i]%2;
            }
            day = 0;
            while (true){
                int day1 = (day+1)/2; // 홀수날 개수
                int day2 = day/2; // 짝수날 개수
                if(day1 <odd){ // 애초에 홀수날 개수보다 작으면 안됨
                    day ++;
                    continue;
                }
                int tempDiff = totalDiff -odd; // 일단 홀수를 빼
                day1 = day1-odd; // 홀수개 뺀만큼 홀수날 개수를 빼
                int day2fromDay1 = day1/2;
                if(tempDiff - 2*(day2 +day2fromDay1)<=0) // 만약 남은홀수개로만든 짝수 + 짝수날 합쳐서 나머지 diff를 넘으면 정답
                    break;
                day ++;
            }
            System.out.println("#"+(t+1)+" "+day);
        }
    }
}
    