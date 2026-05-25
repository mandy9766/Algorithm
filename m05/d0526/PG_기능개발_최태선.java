package m05.d0526;

import java.util.*;

class PG_기능개발_최태선 {
    boolean[] isDone;
    int[] progressArr;
    int[] speedArr;
    int size;
    int doneCount;
    List<Integer> resultList;
    int[] result;
    public int[] solution(int[] progresses, int[] speeds) {
        size = progresses.length;
        isDone = new boolean[size];
        progressArr = progresses;
        speedArr = speeds;
        doneCount = 0;
        resultList = new ArrayList<>();
        
        int front =0;
        while(front<size){
            for(int i=front;i<size;i++){
                progressArr[i] = progressArr[i] + speedArr[i];
            }
            for(int i=front;i<size;i++){
                if(front < size && progressArr[front] >=100){
                    int count = 0;
                    while(front < size && progresses[front] >= 100){
                        count++;
                        front++;
                    }
                    resultList.add(count);
                }
            }
        }
        result = new int[resultList.size()];
        int i=0;
        for(int nowNum: resultList){
            result[i] = nowNum;
            i++;
        }
        return result;
    }
}