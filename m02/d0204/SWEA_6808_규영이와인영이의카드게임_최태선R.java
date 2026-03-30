package d0204;

import java.io.*;
import java.util.*;

public class SWEA_6808_규영이와인영이의카드게임_최태선R {
    static int[] myCards;
    static int[] enemyCards;
    static int[] nowEnemyCards;
    static int winCount;
    static int loseCount;
    static boolean[] used;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [] totalCards;
        
        for(int t=0;t<T;t++){
            totalCards = new int[19]; 
            myCards = new int[9];
            enemyCards = new int[9];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<9;i++){
                myCards[i] = Integer.parseInt(st.nextToken());
                totalCards[myCards[i]] = 1;
            }
            int c = 0;
            for(int i=1;i<19;i++){
                if(totalCards[i] == 1)
                    continue;
                enemyCards[c] = i;
                c++;
            }
            winCount =0;
            loseCount =0;
            used = new boolean[9];
            Arrays.fill(used,false);
            permutation(0,0,0);
            System.out.println("#"+(t+1)+" "+winCount + " "+ loseCount);
        }
    }
    public static void permutation(int count,int myScore,int enemyScore){
        if (count == 9){
            // nowEnemyCards랑 비교해서 점수 더하는 로직
           if (myScore>enemyScore){
                winCount ++;
           }else if(myScore < enemyScore){
                loseCount++;
           }
            return;
        }
        for (int i=0;i<9;i++){
            if (used[i] == true){
                continue;
            }
            used[i] = true;
            int sum = 0;
            sum = enemyCards[i] + myCards[count];
            if (enemyCards[i] > myCards[count])
                permutation(count+1, myScore, enemyScore+sum);
            else
                permutation(count+1, myScore+sum, enemyScore);
            used[i] = false;
        }
        
    }
    
}