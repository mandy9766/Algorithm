package d0331;


import java.io.*;
import java.util.*;

public class BJ_1759_암호만들기_최태선 {
    static int L,C;
    static char[] alphabet;
    static boolean[] isSelected;
    static StringBuilder sb;
    static int moCount,jaCount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        alphabet = new char[C];
        isSelected = new boolean[C];
        for(int i=0;i<C;i++){
            alphabet[i] = st.nextToken().charAt(0);
        }
        moCount = 0;
        jaCount = 0;
        Arrays.sort(alphabet);
        sb = new StringBuilder();   
        dfs(0,0);
        System.out.println(sb);

    }
    static void dfs(int nowEndIdx,int count){
        if(count == L ){
            if(moCount>=1 && jaCount >=2){
                for(int i=0;i<C;i++){
                    if(isSelected[i] == true){
                        sb.append(alphabet[i]);
                    }
                }
                sb.append("\n");
            }
            return;
        }
        if(nowEndIdx>=C)
            return;
        // 뽑는경우
        isSelected[nowEndIdx] = true;
        if(alphabet[nowEndIdx] =='a' || alphabet[nowEndIdx] =='e'|| alphabet[nowEndIdx] =='i'|| alphabet[nowEndIdx] =='o'|| alphabet[nowEndIdx] =='u')
            moCount++;
        else
            jaCount++;
        dfs(nowEndIdx+1, count+1);
        isSelected[nowEndIdx] = false;
       if(alphabet[nowEndIdx] =='a' || alphabet[nowEndIdx] =='e'|| alphabet[nowEndIdx] =='i'|| alphabet[nowEndIdx] =='o'|| alphabet[nowEndIdx] =='u')
            moCount--;
        else
            jaCount--;
        //안뽑는경우
        dfs(nowEndIdx+1,count);
        return;
    }

}
