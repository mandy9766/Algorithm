package d0205;
import java.io.*;
import java.util.*;


public class SWEA_8275_햄스터_최태선 {

    // 출력 순서 만들것
    static int N,X,M; // N은 우리개수, X는 한 우리의 햄스터 최대수, M 정보개수
    static int[][] testCase ;
    static int[] possibleValues;
    static int[] answerValues;
    static int answerSumVal;
    static boolean isFound;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            testCase = new int[M][3];
            possibleValues = new int[N];
            answerValues = new int[N];
            answerSumVal = 0;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<3;j++){
                    testCase[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isFound = false;
            Permutation(0);
            if(isFound == false){
                System.out.println("#"+(t+1)+" -1");
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append("#"+(t+1));
                for(int i=0;i<N;i++){
                    sb.append(" " +answerValues[i]);
                }
                System.out.println(sb);
            }
        }
    }
    public static void Permutation(int count){
        if(count == N){
            if(check()){
                isFound = true;
                int sum =0;
                for(int i=0;i<N;i++){
                    sum += possibleValues[i];
                }
                if (sum > answerSumVal){
                    answerSumVal = sum;
                    for(int i=0;i<N;i++){
                        answerValues[i] = possibleValues[i];
                    }
                }
            }
            return;
        }
        for(int i=0;i<=X;i++){
            possibleValues[count] = i;
            Permutation(count+1);
        }
    }   
    public static boolean check()
    {  
        for(int i=0;i<M;i++){
            int start = testCase[i][0];
            int end = testCase[i][1];
            int sumVal = testCase[i][2];
            int sum =0;
            for(int j=start-1;j<end;j++){
                sum+= possibleValues[j];
            }
            if(sum != sumVal){
                return false;
            }
        }
        return true;
    }
}
