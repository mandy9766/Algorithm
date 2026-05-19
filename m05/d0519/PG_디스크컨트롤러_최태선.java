package m05.d0519;

import java.util.*;

class PG_디스크컨트롤러_최태선 {
    PriorityQueue<int[]> pq;
    boolean isProcessing;
    int leftCount;
    int result;
    int nowAddIdx;
    int [][] projects;
    public int solution(int[][] jobs) {
        result = 0;
        pq = new PriorityQueue<>((a,b)-> {
            if(a[2] != b[2])
                return Integer.compare(a[2],b[2]);
            else{
                if(a[1] != b[1])
                    return Integer.compare(a[1],b[1]);
                else
                    return Integer.compare(a[0],b[0]);
            }
        });
        nowAddIdx = 0;
        projects = new int[jobs.length][3];
        for(int i=0;i<jobs.length;i++){
            projects[i][0] = i;
            projects[i][1] = jobs[i][0];
            projects[i][2] = jobs[i][1];
        }
        Arrays.sort(projects,(a,b) -> Integer.compare(a[1],b[1]));
        
        for(int i=0;i<555555;i++){
            if(nowAddIdx < projects.length && projects[nowAddIdx][1] == i){
                while(true){
                    pq.add(projects[nowAddIdx]);
                    nowAddIdx ++;
                    if(nowAddIdx >= projects.length || projects[nowAddIdx][1] != i){
                        break;
                    }
                }
            }
            if(!isProcessing && !pq.isEmpty()){
                int[] nowNode = pq.poll();
                int processNum = nowNode[0];
                int processStart = nowNode[1];
                leftCount = nowNode[2];
                result += i - processStart+leftCount;
                isProcessing = true;
            }else{
                leftCount --;
                if(leftCount == 0)
                {
                    isProcessing = false;
                    if(!pq.isEmpty()){
                        int[] nowNode = pq.poll();
                        int processNum = nowNode[0];
                        int processStart = nowNode[1];
                        leftCount = nowNode[2];
                        result += i - processStart+leftCount;
                        isProcessing = true;
                    }
                }
                    
            }
            
        }
        return result/projects.length;
        
    }
}