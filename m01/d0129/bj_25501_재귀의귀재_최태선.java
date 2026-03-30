package d0129;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class bj_25501_재귀의귀재_최태선 {
    static int count =0;
    public static int recursion(String s, int l, int r){
        count ++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t=0;t<T;t++){
            count = 0;
            System.out.println(isPalindrome(br.readLine()) + " " + count);
        }

    }
}
