package d0224;

import java.io.*;
import java.util.*;

public class SWEA_3000_중간값구하기_최태선 {
    static int T,N,mid;
    static long result;
    static PriorityQueue<Integer> leftQueue,rightQueue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            result = 0;
            leftQueue = new PriorityQueue<>(Collections.reverseOrder());
            rightQueue = new PriorityQueue<>();
            mid = Integer.parseInt(st.nextToken());
            rightQueue.add(mid);
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                leftQueue.add(n1);
                leftQueue.add(n2);
                if(leftQueue.peek() > rightQueue.peek()){
                    int tempL = leftQueue.poll();
                    int tempR = rightQueue.poll();
                    rightQueue.add(tempL);
                    leftQueue.add(tempR);
                }
                if(leftQueue.peek() > rightQueue.peek()){
                    int tempL = leftQueue.poll();
                    int tempR = rightQueue.poll();
                    rightQueue.add(tempL);
                    leftQueue.add(tempR);
                }
                if(leftQueue.size()>rightQueue.size()){
                    rightQueue.add(leftQueue.poll());
                }
                result += rightQueue.peek()%20171109;
                result %= 20171109;
            }
            System.out.println("#"+t+" "+result);
        }
        
    }
}
