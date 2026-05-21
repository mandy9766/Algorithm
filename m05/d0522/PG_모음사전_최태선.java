package m05.d0522;

import java.util.ArrayList;
import java.util.List;

public class PG_모음사전_최태선 {
    int size;
    List<String> list;
    String[] charSet = {"A","E","I","O","U"};
    int resultIdx;
    public int solution(String word) {
        list = new ArrayList<>();
        dfs(0,"");
        resultIdx =0;
        for(String val : list){
            if(val.equals(word))
                return resultIdx+1;
            resultIdx++;
                
        }
        return -1;
    }
    void dfs(int depth, String nowStr){
        if(!nowStr.equals(""))
            list.add(nowStr);
        if(depth == 5)
            return;
        for(int i=0;i<5;i++){
            dfs(depth+1,nowStr+charSet[i]);
        }
    }
}
