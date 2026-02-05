package d0205;

import java.io.*;
import java.util.*;

class Students{
        public int num; // 번호
        public int count; // 추천개수
        public int order; // 순서
        public Students(int num,int count,int order){
            this.num = num;
            this.count =count;
            this.order =order;
    }
}
public class BJ_1713_후보추천하기_최태선 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Students[] pictures = new Students[N];
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int nowN =0;
        for(int i=0;i<count;i++){
            
            int sNum = Integer.parseInt(st.nextToken());
            if (nowN<N){
                boolean isExist = false;
                for(int j=0;j<nowN;j++){
                    if(pictures[j].num == sNum){
                        isExist = true;
                        pictures[j].count ++;
                        break;
                    }
                }
                if(isExist == false){
                    pictures[nowN] = new Students(sNum,1,i);
                    nowN ++;
                }
            }
            else{
                boolean isExist = false;
                for(int j=0;j<N;j++){
                    if(pictures[j].num == sNum){
                        isExist = true;
                        pictures[j].count ++;
                        break;
                    }
                }
                if (isExist == false){
                    // 만약 없는경우 
                    int minJ = 0;
                    Students minStudents = pictures[0];
                    for(int j=1;j<N;j++){
                        if (minStudents.count > pictures[j].count)
                        {
                            minStudents = pictures[j];
                            minJ = j;
                        }else if(minStudents.count == pictures[j].count){
                            if(minStudents.order > pictures[j].order){
                                minStudents = pictures[j];
                                minJ = j;
                            }
                        }
                    }
                    minStudents.count = 0;
                    pictures[minJ] = new Students(sNum, 1, i);
                }
            }
            
        }
        
        int[] arr = new int[nowN];
        for(int i=0;i<nowN;i++){
            arr[i] = pictures[i].num;
        }
        Arrays.sort(arr);
        for(int i=0;i<nowN;i++){
            System.out.print(arr[i]+" ");
        }


    }
    
}
