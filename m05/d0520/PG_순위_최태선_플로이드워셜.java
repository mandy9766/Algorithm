package m05.d0520;

public class PG_순위_최태선_플로이드워셜 {
    int N;
    int[][] Results;
    boolean[][] graph;
    int answer;
    
    public int solution(int n, int[][] results) {
        N = n;
        Results = results;
        graph = new boolean[N+1][N+1];
        answer = 0;
        for(int i=0;i<results.length;i++){
            int winner = results[i][0];
            int loser = results[i][1];
            graph[winner][loser] = true;
        }
        for(int k=1;k<N+1;k++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(graph[i][k] == true && graph[k][j] == true)
                        graph[i][j] = true;
                }
            }
        }
        for(int i=1;i<N+1;i++){
            int count = 0;
            for(int j=1;j<N+1;j++){
                if (graph[i][j] == true || graph[j][i] == true){
                    count ++;
                }
            }
            if(count == N-1)
                answer ++;
        }
        return answer;
    }
}
