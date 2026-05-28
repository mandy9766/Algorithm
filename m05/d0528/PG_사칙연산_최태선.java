package m05.d0528;

import java.util.Arrays;

public class PG_사칙연산_최태선 {
    int [][] maxDp;
    int [][] minDp;
    String [] ops;
    int[] nums;
    int numSize;
    int opSize;
    public int solution(String arr[]) {
        opSize = arr.length/2;
        numSize = arr.length/2+1;
        nums = new int[numSize];
        ops = new String[opSize];
        maxDp = new int[numSize][numSize];
        minDp = new int[numSize][numSize];
        for(int i=0;i<numSize;i++){
            nums[i] = Integer.parseInt(arr[i*2]);
        }
        for(int i=0;i<opSize;i++){
            ops[i] = arr[i*2+1];
        }
        for(int i=0;i<numSize;i++){
            Arrays.fill(maxDp[i],Integer.MIN_VALUE);
            Arrays.fill(minDp[i],Integer.MAX_VALUE);
        }
        // 하나짜리 dp 초기화
        for(int i=0;i<numSize;i++){
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
        }
        // 두개짜리 dp 초기화
        for(int i=0;i<numSize-1;i++){
            if(ops[i].equals("+")){
                maxDp[i][i+1] = nums[i] +nums[i+1];
                minDp[i][i+1] = nums[i] +nums[i+1];
            }
            else{
                maxDp[i][i+1] = nums[i] -nums[i+1];
                minDp[i][i+1] = nums[i] -nums[i+1];
            }
        }
        // dp 로직
        for(int size = 3;size<=numSize;size++){
            // size값일때 -> 0에서0 + 1에서 size-1 인덱스까지 or 0~i, i+1에서 size-1;
            for(int start = 0;start+size-1<=numSize-1;start++){
                // 연산자 인덱스 어디?
                for(int opIdx=start;opIdx<start+size-1;opIdx++){
                    if(ops[opIdx].equals("-")){
                        maxDp[start][start+size-1] = Math.max(maxDp[start][start+size-1],maxDp[start][opIdx] - minDp[opIdx+1][start+size-1]);
                        minDp[start][start+size-1] = Math.min(minDp[start][start+size-1],minDp[start][opIdx] - maxDp[opIdx+1][start+size-1]);
                    }
                    else{
                        maxDp[start][start+size-1] = Math.max(maxDp[start][start+size-1],maxDp[start][opIdx] + maxDp[opIdx+1][start+size-1]);
                        minDp[start][start+size-1] = Math.min(minDp[start][start+size-1],minDp[start][opIdx] + minDp[opIdx+1][start+size-1]);
                    }
                }
            }
        }
        return maxDp[0][numSize-1];
    }
}
