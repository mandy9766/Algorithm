package d0205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취_최태선R {
    static int[][] graph;
    static int N,M,C;
    static int maxVal;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            maxVal = 0;
            graph = new int[N][N];
            
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] valGraph = new int[N][N-M+1];
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N-M+1;j++){
                    maxVal = 0;
                    Comb(0,0,0,0,i,j);
                    valGraph[i][j] = maxVal;
                }
            }
            answer= 0;
            for(int i1=0;i1<N;i1++){
                for(int j1=0;j1<N-M+1;j1++){
                    for(int i2=0;i2<N;i2++){
                        for(int j2=0;j2<N-M+1;j2++){
                            if(check(i1,i2,j1,j2)){
                                answer = Math.max(answer,valGraph[i1][j1]+valGraph[i2][j2]);
                            }
                        }
                    }
                }
            }

            System.out.println("#"+(t+1)+" "+answer);
        }
    }
    public static void Comb(int count,int depth,int nowSum,int nowVal,int li,int lj){
        if(depth == M){
            if(nowSum<=C){
                maxVal = Math.max(maxVal, nowVal);
            }
            return;
        }
        // 넣을때 
        Comb(count+1,depth+1,nowSum+graph[li][lj+depth],nowVal+graph[li][lj+depth]*graph[li][lj+depth],li,lj); //count 값 올리고, depth값 올리고 -> li,lj 넣는것
        Comb(count,depth+1,nowSum,nowVal,li,lj);
        // 안넣을때
    }
    
    public static boolean check(int i1,int i2, int j1,int j2){
        if (i1 ==i2){
            if((j2-j1)>=M){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return true;
        }
    }
}
