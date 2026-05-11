package m05.d0511;

import java.util.HashSet;
import java.util.Set;

public class PG_폰켓몬_최태선 {
     Set<Integer> set;
    public int solution(int[] nums) {
        set = new HashSet<>();
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        if(set.size() > size/2)
            return size/2;
        else
            return set.size();
    }
}
