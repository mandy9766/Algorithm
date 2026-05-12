package m05.d0512;

import java.util.*;

public class PG_조이스틱_최태선 {
     class Node{
        int count;
        int visited;
        int idx;
        Node(int count,int visited,int idx){
            this.count = count;
            this.visited = visited;
            this.idx = idx;
        }
    }
    int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1}; // 25개
    int nameSize;
    char[] nameChar;
    int allVisited;
    public int solution(String name) {
        nameSize = name.length();
        nameChar = name.toCharArray();
        allVisited = (1<<nameSize)-1;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.count,b.count));
        int startVisited = 1;
        for(int i=1;i<nameSize;i++){
            if(nameChar[i] == 'A')
            {
                int target = 1<<i;
                startVisited = startVisited | target;
            }
                
        }
        Node startNode = new Node(arr[nameChar[0]-'A'],startVisited,0);
        pq.add(startNode); // 수정: 클래스명 Node -> 객체명 startNode
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            if(nowNode.visited == allVisited)
                return nowNode.count;
            
            int nowVisited = nowNode.visited; // 수정: int -> boolean[]
            int nowIdx = nowNode.idx;
            int leftIdx = nowIdx-1;
            if(leftIdx == -1)
                leftIdx = nameSize - 1; // 수정: nameSize -> nameSize - 1 (인덱스 범위)
            int rightIdx = (nowIdx+1)%nameSize;
            int leftMoveCount = 1;
            int rightMoveCount = 1;
            
            // 현재에서 왼쪽으로 이동할때    
            while((nowVisited & (1<<leftIdx))!= 0){
                leftIdx --;
                if(leftIdx == -1)
                    leftIdx = nameSize - 1; // 수정: nameSize -> nameSize - 1
                leftMoveCount ++;                
            }

            // 수정: visitedCount -> nowNode.visitedCount, count 합산 로직 유지
            pq.add(new Node(nowNode.count + arr[nameChar[leftIdx]-'A'] + leftMoveCount, nowVisited|(1<<leftIdx), leftIdx));
            
            
            // 현재에서 오른쪽으로 이동할때
            while((nowVisited & (1<<rightIdx)) != 0){
                rightIdx = (rightIdx+1)%nameSize;
                rightMoveCount ++;                
            }

            // 수정: visitedCount -> nowNode.visitedCount, count 합산 로직 유지
            pq.add(new Node(nowNode.count + arr[nameChar[rightIdx]-'A'] + rightMoveCount, nowVisited|(1<<rightIdx), rightIdx));
        }
        return 0;
    }
}
