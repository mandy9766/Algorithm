package d0129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_18511_큰수구성하기_최태선 {
    static int maxVal = 0;
    static int[] nums;
    static int count;
    static int baseNum;
    public static void main(String[] args)throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        baseNum = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        nums = new int[count];

        for(int i=0;i<count;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        makeMax(0);
        System.out.println(maxVal);

    }
    public static void makeMax(int s){
        if(s<=baseNum){
            maxVal = Math.max(s,maxVal);
            for(int i=0;i<count;i++){
                long ns = s*10+nums[i];
                if(ns <=baseNum)
                    makeMax((int)ns);
            }
        }
        return;
    }
}
