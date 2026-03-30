package d0204;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int a =0;
        int b =0;
        int size = A.length;
        System.out.println(size);
        int answer = 0;
        while(a<size && b<size){
            if(A[a]>=B[b]){
                b++;
            }
            else{
                answer ++;
                a++;
                b++;
            }
        }
        
        
        return answer;
    }
}