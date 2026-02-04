package d0204;

import java.io.*;
import java.util.*;


public class SWEA_6808_규영이와인영이의카드게임_최태선 {
    static int[] myCards;
    static Deque<Integer> enemyCards;
    static Deque<Integer> nowEnemyCards;
    static int winCount;
    static int loseCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [] totalCards;
        
        for(int t=0;t<T;t++){
            totalCards = new int[19]; 
            myCards = new int[9];
            enemyCards = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<9;i++){
                myCards[i] = Integer.parseInt(st.nextToken());
                totalCards[myCards[i]] = 1;
            }
            for(int i=1;i<19;i++){
                if(totalCards[i] == 1)
                    continue;
                enemyCards.add(i);
            }
            winCount =0;
            loseCount =0;
            nowEnemyCards = new ArrayDeque<>();
            permutation(0);
            System.out.println("#"+(t+1)+" "+winCount + " "+ loseCount);
        }
    }
    public static void permutation(int count){
        if (count == 9){
            // nowEnemyCards랑 비교해서 점수 더하는 로직
            int myScore = 0;
            int enemyScore = 0;
            int[] enemyArr = new int[9];
            Iterator <Integer>it = nowEnemyCards.iterator();
            int c =0;
            while(it.hasNext()){
                enemyArr[c] = it.next();
                c++;
            }
            for(int i=0;i<9;i++){
                if(myCards[i] > enemyArr[i]){
                    myScore += myCards[i] + enemyArr[i];
                }
                else{
                    enemyScore += myCards[i] + enemyArr[i];
                }
            }
            if(myScore > enemyScore){
                winCount ++;
            }
            else if (enemyScore > myScore){
                loseCount ++;
            }
            return;
        }
        int size = 9-count;
        for(int i=0;i<size;i++){
            int a = enemyCards.removeFirst();
            nowEnemyCards.addLast(a);
            permutation(count+1);
            nowEnemyCards.removeLast();
            enemyCards.addLast(a);
        }
        
        
    }
    
}
