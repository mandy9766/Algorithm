package m04.d0429;

import java.util.*;
public class PG_모의고사_최태선 {
    int[] count;
    int[] arr;
    int[][] numSet = new int[][]{
        {1,2,3,4,5}, // idx 4최대
        {2,1,2,3,2,4,2,5}, // idx 7 최대
        {3,3,1,1,2,2,4,4,5,5} // idx 9 최대
    };
    int[] mod = {5,8,10};
    List<Integer> resultList;

    public int[] solution(int[] answers) {
        arr = answers;
        count = new int[4];
        int size = arr.length;
        for(int i=0;i<3;i++){
            int nowMod = mod[i];
            int[] nowSet = numSet[i];
            int nowIdx = 0;
            for(int j=0;j<size;j++){
                if(nowSet[nowIdx] == arr[j]){
                    count[i+1]++;
                }
                nowIdx = (nowIdx+1)%nowMod;
            }
        }
        int maxVal=0;
        for(int i=1;i<4;i++){
            maxVal =Math.max(maxVal,count[i]);
        }
        resultList = new ArrayList<>();
        for(int i=1;i<4;i++){
            if(count[i] == maxVal)
                resultList.add(i);
        }
        int [] result = resultList.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}


