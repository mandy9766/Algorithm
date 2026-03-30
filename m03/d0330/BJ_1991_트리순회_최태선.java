package d0330;

import java.io.*;
import java.util.*;

public class BJ_1991_트리순회_최태선 {
    static int N;
    static class Node{
        char alphabet;
        Node left;
        Node right;
        Node(char alphabet){
            this.alphabet =alphabet;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        Node[] tree = new Node[26];
        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(tree[root-'A'] == null){
                tree[root-'A'] = new Node(root);
            }
            if(left != '.'){
                tree[left-'A'] = new Node(left);
                tree[root-'A'].left = tree[left-'A'];
            }
            if(right != '.'){
                tree[right-'A'] = new Node(right);
                tree[root-'A'].right = tree[right-'A'];
            }
        }
        preOrder(tree[0]);
        System.out.println();
        midOrder(tree[0]);
        System.out.println();
        pastOrder(tree[0]);
        System.out.println();
    }
    static void preOrder(Node node){
        if(node == null)
            return;
        System.out.print(node.alphabet);
        preOrder(node.left);
        preOrder(node.right);
    }
    static void midOrder(Node node){
        if(node == null)
            return;
        midOrder(node.left);
        System.out.print(node.alphabet);
        midOrder(node.right);
    }
    static void pastOrder(Node node){
        if(node == null)
            return;
        pastOrder(node.left);
        pastOrder(node.right);
        System.out.print(node.alphabet);
    }
}
