package samsung_B_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726_이진수표현_최태선R {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int num = (1<<N)-1;
            if ((M&num) == num)
                System.out.println("#"+(t+1) + " ON");
            else
                System.out.println("#"+(t+1) + " OFF");
                
        }

    }
}
