package d0309;
import java.io.*;
import java.util.*;

public class BJ_20040_사이클게임_최태선 {
    static int N,M;
    static int[] parents;
    static int count;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," "); 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        make();
        ans = 0;
        count = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a, b) == false){
                if(ans == 0)
                    ans = count+1;
            }
            else{
                count ++;
            }
        }
        if(ans == 0)
            System.out.println(0);
        else
            System.out.println(ans);
    }
    static void make(){
        for(int i=0;i<N;i++)
            parents[i] = i;
    }    
    static int find(int x){
        if(parents[x] == x)
            return parents[x];
        else
            return parents[x] = find(parents[x]);
    }
    static boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY)
            return false;
        else{
            parents[rootY] = rootX;
            return true;
        }
    }
}
