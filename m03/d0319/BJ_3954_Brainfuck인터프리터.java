package d0319;

import java.io.*;
import java.util.*;

public class BJ_3954_Brainfuck인터프리터 {
    static int[] arr;
    static char[]op;
    static boolean[] opBool;
    static Deque<Character> deque;
    static int T;
    static int M,C,S;
    static boolean isPossible;
    static int roopS,roopE;
    static int[] pair;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            arr = new int[M];
            op = br.readLine().toCharArray();
            opBool = new boolean[C];
            deque = new ArrayDeque<>();
            pair = new int[C];
            Arrays.fill(pair,-1);
            char[] tempChar = br.readLine().toCharArray();
            for(int i=0;i<S;i++){
                deque.add(tempChar[i]);
            }
            int nowPointer =0;
            int nowOp =0;
            int count = 0;
            while(true){
                if(count == 50000000){
                    Arrays.fill(opBool,false);
                    isPossible = false;
                }
                if(count == 100000000){
                    for(int i=C-1;i>=0;i--){
                        if(opBool[i] == true){
                            roopE = i;
                            // roopE에 짝이맞는 roopS
                            roopS = pair[i]; // 구해서넣기
                            break;
                        }
                    }
                    break;
                }
                count ++;
                if(nowOp >= C) // Op가 끝났으면 정상종료
                {
                    isPossible = true;
                    break;
                }
                char nowOrder = op[nowOp];
                opBool[nowOp] = true;
                if(nowOrder == '+'){
                    arr[nowPointer] ++;
                    if(arr[nowPointer] == 256){
                        arr[nowPointer] = 0;
                    }
                    nowOp++;
                }else if(nowOrder == '-'){
                    arr[nowPointer] --;
                    if(arr[nowPointer] == -1)
                        arr[nowPointer] =255;
                    nowOp++;
                }else if(nowOrder == '<'){
                    nowPointer --;
                    if(nowPointer == -1)
                        nowPointer = M-1;
                    nowOp++;
                }else if(nowOrder == '>'){
                    nowPointer ++;
                    if(nowPointer == M)
                        nowPointer = 0;
                    nowOp++;
                }else if(nowOrder==','){
                    if(deque.isEmpty())
                        arr[nowPointer] = 255;
                    else
                        arr[nowPointer] = deque.poll();
                    nowOp++;
                }else if(nowOrder =='['){
                    if(arr[nowPointer] == 0){
                        if(pair[nowOp] == -1){
                            int pairNum = getIdx(1, nowOp);// [에 짝을 찾아서 그값 하나 높은것으로 nowOp 옮김
                            pair[nowOp] = pairNum;
                            nowOp = pairNum+1;
                        }else{
                            nowOp = pair[nowOp]+1;
                        }
                    }
                    else
                        nowOp++;
                }else if(nowOrder ==']'){
                    if(arr[nowPointer] != 0){
                        if(pair[nowOp] == -1){
                            int pairNum = getIdx(-1, nowOp);// [에 짝을 찾아서 그값 하나 높은것으로 nowOp 옮김
                            pair[nowOp] = pairNum;
                            nowOp = pairNum+1;
                        }else{
                            nowOp = pair[nowOp]+1;
                        }
                    }
                    else
                        nowOp++;
                }else{
                    nowOp++;
                }
            }
            if(isPossible == true)
                System.out.println("Terminates");
            else
                System.out.println("Loops " +roopS +" "+roopE);
        }
    }
    static int getIdx(int startNum ,int startIdx){ // [이면 +1 , ]이면-1
        int nowVal = startNum;
        if(startNum > 0) // [ 들어온상황
        {
            // 오른쪽으로 쭉
            for(int i=startIdx+1;i<C;i++){
                int nowOp = op[i];
                if(nowOp == '[')
                {
                    nowVal ++;
                }else if (nowOp ==']'){
                    nowVal --;
                }
                if(nowVal == 0)
                    return i; // 괄호 딱처리됐을때 idx 반환
            }
        }
        else{
            // 왼쪽으로 쭉
            for(int i=startIdx-1;i>=0;i--){
                int nowOp = op[i];
                if(nowOp == '['){
                    nowVal ++;
                }
                else if(nowOp ==']'){
                    nowVal --;
                }
                if(nowVal == 0)
                    return i;
            }
        }
        return -1;
    }  
}
