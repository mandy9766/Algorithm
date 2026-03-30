package d0209;
import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서연결하기_최태선R {
    static int N,coreCount,minVal,target,maxVal;
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
            maxVal = 0;
            coreCount = core.size(); // 코어카운트부터 하나씩 줄여가며 되나 체크, 그때의 전선값도 체크
            target = coreCount;
            selectedCore = new boolean[coreCount];
            select(0,0,0);   
            if (minVal == Integer.MAX_VALUE)
                System.out.println("#"+(t+1) + " " +0);   
            else
                System.out.println("#"+(t+1) + " " +minVal);
        }
    }
    static void select(int availableCoreCount,int lineCount,int idx){
        if(availableCoreCount + (coreCount-idx) < maxVal)
            return;
        if(idx == coreCount){
            if (maxVal < availableCoreCount){
                maxVal = availableCoreCount;
                minVal = lineCount;
            }else if(maxVal == availableCoreCount){
                minVal = Math.min(minVal,lineCount);
            }
            // selected된거 가능한지체크하고, 되면 possible, minVal 업데이트
            return;
        }
        int nowI = core.get(idx)[0];
        int nowJ = core.get(idx)[1];
        for(int k=0;k<4;k++){
            if(beam(nowI, nowJ, k)){
                int count = shoot(nowI, nowJ, k, 2);
                select(availableCoreCount+1,lineCount+count,idx+1);
                shoot(nowI, nowJ, k, 0);
            }
        }
        select(availableCoreCount,lineCount,idx+1);
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
