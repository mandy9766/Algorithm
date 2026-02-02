package d0202;
import java.io.*;



public class swea_1226_미로_최태선 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean isPossible = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t=0;t<10;t++){
            int tNum = Integer.parseInt(br.readLine());
            graph = new int[16][16];
            visited = new boolean[16][16];
            for(int i=0;i<16;i++){
                char[] cArr = br.readLine().toCharArray();
                for(int j=0;j<16;j++){
                    int num = cArr[j] -'0';
                    graph[i][j] = num;
                }
            }
            boolean started = false;
            for(int i=0;i<16 && !started;i++){
                for(int j=0;j<16;j++){
                    if (graph[i][j] == 2){
                        visited[i][j] = true;
                        Dfs(i,j);
                        started = true;
                        break;
                    }
                }
            }
            if (isPossible){
                System.out.println("#"+tNum+" "+1);
            }
            else{
                System.out.println("#"+tNum+" "+0);
            }
            isPossible = false;
        }
    }
    public static void Dfs(int i,int j){
        if(graph[i][j] == 3){
            isPossible = true;
            return;
        }
        for (int k=0;k<4 ;k++){
            int ni = i+di[k];
            int nj = j+dj[k];
            if(ni<0 || nj<0 ||ni>=16 || nj>=16 || isVisited(ni, nj))
                continue;
            if(graph[ni][nj] != 1){
                visited[ni][nj] = true;
                Dfs(ni,nj);
            }
            
        }
    }
    public static boolean isVisited(int i,int j){
        if (visited[i][j] == true){
            return true;
        }
        else{
            return false;
        }
    }
   
}
