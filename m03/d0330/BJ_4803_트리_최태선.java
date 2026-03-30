package d0330;
import java.io.*;
import java.util.*;

public class BJ_4803_트리_최태선 {
    static int N,M;
    static int[] parents;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =0;
        while(true){
            t ++;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0)
                return;
            makeSet();
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            int count =0;
            for(int i=1;i<N+1;i++){
                if(parents[i] == -1)
                    count ++;
            }
            if(count == 0){
                System.out.println("Case "+t+": No trees.");
            }else if(count == 1){
                System.out.println("Case "+t+": There is one tree.");
            }else{
                System.out.println("Case "+t+": A forest of " +count+" trees.");
            }

        }
        
    }
    static void makeSet(){
        parents = new int[N+1];
        Arrays.fill(parents,-1);
    }
    static int findSet(int x){
        if(parents[x]<0)
            return x;
        else
            return parents[x] = findSet(parents[x]);
    }
    static void union(int x, int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        if(rootX == rootY){
            parents[rootX] = -2;
            return;
        }
        if(parents[rootX]<parents[rootY]){
            parents[rootY] = rootX;
        }else{
            parents[rootX] = rootY;
        }
        return;
    }
}
