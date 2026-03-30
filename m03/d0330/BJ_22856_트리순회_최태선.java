package d0330;

import java.io.*;
import java.util.*;


public class BJ_22856_트리순회_최태선 {
    static class Node{
        int num;
        Node left;
        Node right;
        Node(int num){
            this.num = num;
            left = null;
            right = null;
        }
    }
    
    static int N;
    static Node[] tree;
    static int count;
    static boolean[] visited;
    static int visitedCount;
    static int end;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];
        count = 0;
        visited = new boolean[N+1];
        visitedCount = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if(tree[root] == null )
                tree[root] = new Node(root);
            if(left != -1){
                if(tree[left] == null) tree[left] = new Node(left);
                tree[root].left = tree[left];
            }
            if(right != -1){
                if(tree[right] == null) tree[right] = new Node(right);
                tree[root].right = tree[right];
            }
        }
        end = findEnd(1);
        visitedCount =1;
        order(1);
        System.out.println(count);
    }
    static void order(int nowNum){
        if(tree[nowNum].left != null && visited[tree[nowNum].left.num] == false){
            count++;
            int nextNum = tree[nowNum].left.num;
            visited[nextNum] = true;
            visitedCount ++;
            order(nextNum);
            count++;
        }
        if(tree[nowNum].right != null && visited[tree[nowNum].right.num] == false){
            count ++;
            int nextNum = tree[nowNum].right.num;
            visited[nextNum] = true;
            visitedCount ++;
            order(nextNum);
            count++;
        }
        if(nowNum == end){
            System.out.println(count);
            System.exit(0); // 시스템 강제 종료 (깔끔하게 끝내기)
        }

        return;        
    }
    static int findEnd(int top){
        if(tree[top].right == null) 
            return top;
        return findEnd(tree[top].right.num);
    }
}
