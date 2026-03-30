package d0209;
import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서연결하기_최태선 {
    static int N,coreCount,minVal,target;
    static boolean isPossible;
    static int[][] graph;
    static List<int[]> core; // ~번째 코어 i,j
    static boolean[] selectedCore;
    static int []di ={-1,1,0,0};
    static int []dj ={0,0,-1,1};
    public static void main(String[] args) throws Exception{
        // 최대부터 구한다(전부 연결됨 -> -1개 연결됨) => 된다 : 전선 길이의 합이 최소가 되는 값.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            core = new ArrayList<>();
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if(graph[i][j] == 1){
                        if (i== 0 || i==N-1 || j ==0 || j == N-1)
                            graph[i][j] = 2; // 이미 됐으니까 전선이랑 같은취급
                        else
                            core.add(new int[]{i,j});
                    }
                }
            }
            isPossible = false;
            minVal = Integer.MAX_VALUE;
            coreCount = core.size(); // 코어카운트부터 하나씩 줄여가며 되나 체크, 그때의 전선값도 체크
            target = coreCount;
            selectedCore = new boolean[coreCount];
            while(target>0){
                select(0,0);
                if(isPossible)
                    break;
                target --;
            }        
            System.out.println("#"+(t+1) + " " +minVal);

        }
    }
    static void select(int selectedCount,int start){
        if(selectedCount == target){
            // selected된거 가능한지체크하고, 되면 possible, minVal 업데이트
            check(selectedCount,0,0,0);
            return;
        }
        for(int i=start;i<coreCount;i++){
            if(selectedCore[i] == false){
                selectedCore[i] = true;
                select(selectedCount+1,i+1);
                selectedCore[i] = false;
            }
        }
    }
    static void check(int selectedCount,int nowCoreCount,int start,int lineCount){
        if(selectedCount == nowCoreCount){
            isPossible = true;
            minVal = Math.min(lineCount,minVal);
            return;
        }
        //selected된 코어 마다 4가지 해보고 되면 -> 다음거 넣고 되는거만 쭉쭉해서 마지막까지 되면 
        // -> isPossible = true, minVal 업데이트
            for(int p =start;p<coreCount;p++){
                if(selectedCore[p] == true){
                    int i = core.get(p)[0];
                    int j = core.get(p)[1];
                    for(int k=0;k<4;k++){
                        if(beam(i,j,k))
                        {   
                            int count = shoot(i, j, k,2); // 그래프 전기발사 후
                            check(selectedCount,nowCoreCount+1,p+1,lineCount+count);
                            shoot(i, j, k, 0); // 다시 그래프 원복
                        }
                    }
                }
            }
    }
    static boolean beam(int i ,int j ,int k){
        int count = 1;
        while (true){
            
            int ni = i + di[k]*count;
            int nj = j + dj[k]*count;
            if (ni == 0 || ni == N-1 || nj == 0 || nj == N-1 ){
                if(graph[ni][nj] == 0)
                    return true;
                else
                    return false;
            }
            if(graph[ni][nj] != 0)
                return false;
            count ++;
        }
        
    }
    static int shoot(int i,int j, int k ,int num){
        int count = 1;
        while(true){
            int ni = i+di[k]*count;
            int nj = j+dj[k]*count;
            graph[ni][nj] = num;
            if (ni == 0 || ni == N-1 || nj == 0 || nj == N-1 ){
                return count;
            }
            count ++;
        }
    }

}
