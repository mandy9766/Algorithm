package m04.d0424;

public class PG_타겟넘버_최태선 {
     int size;
    int answer;    
    int target;
    int[] numbers;
    public int solution(int[] numbers, int target) {
        answer = 0;
        size = numbers.length;
        this.target = target;
        this.numbers = numbers;
        dfs(0,0);
        return answer;
    }
    void dfs(int depth,int nowVal){
        if(depth == size){
            if(nowVal == target)
                answer++;
            return;
        }
        dfs(depth+1,nowVal+numbers[depth]);
        dfs(depth+1,nowVal-numbers[depth]);
        
    }
}
