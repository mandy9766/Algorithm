package d0310;

import java.io.*;
import java.util.*;


public class SWEA_2382_미생물격리_최태선 {
    static int T,N,M,K;
    static int[] dx = {-3,-1,1,0,0};//더미,상 하 좌 우
    static int[] dy = {-3,0,0,-1,1};
    static Deque<int[]> bugList;
    static Map<Integer,int[]> tempMap;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            bugList = new ArrayDeque<>();
            tempMap = new HashMap<>();
            result = 0;
            for(int k=0;k<K;k++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                bugList.add(new int[]{x, y, w, d});
            }
            for(int m=0;m<M;m++){
                while(!bugList.isEmpty()){
                    int[] nowBug = bugList.poll();
                    int x = nowBug[0];
                    int y = nowBug[1];
                    int w = nowBug[2];
                    int d = nowBug[3];
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    // 만약 움직인자리가 가장자리면 방향 반대로, 군집 반으로줄이기
                    if(nx == 0 || ny == 0 || nx== N-1 || ny == N-1){
                        w = w/2;
                        if(d == 1)
                            d = 2;
                        else if (d==2)
                            d= 1;
                        else if(d==3)
                            d=4;
                        else if (d==4)
                            d=3;
                    }
                    // 군집 0됐으면 map에 안넣어서 빼버림 아예
                    if (w == 0)
                        continue;
                    // 만약 같은 공간에 벌레가 이미 들어와있으면
                    if(tempMap.containsKey(1000*nx+ny)){
                        int[] temp = tempMap.get(1000*nx+ny);
                        int tempX = temp[0];
                        int tempY = temp[1];
                        int tempW = temp[2];// 지금까지 맥스군집 크기
                        int tempS = temp[3];// 합
                        int tempD = temp[4];// 지금까지 맥스군집의 방향
                        if (w>tempW){ // 새로들어온 벌레가 지금까지 군집보다 크면
                            tempMap.put(1000*nx+ny,new int[]{nx,ny,w,tempS+w,d}); // 새로운 벌레군집으로 갱신
                        }else{ // 새로들어온 벌레가 작으면
                            tempMap.put(1000*nx+ny,new int[]{nx,ny,tempW,tempS+w,tempD});// 군집크기만 키워줌
                        }
                    //만약 없으면
                    }else{
                        tempMap.put(1000*nx+ny,new int[]{nx,ny,w,w,d});
                    }
                }
                for(int[] temp : tempMap.values()){
                    int tempX = temp[0];
                    int tempY = temp[1];
                    int tempW = temp[2];// 지금까지 맥스군집 크기
                    int tempS = temp[3];// 합
                    int tempD = temp[4];// 지금까지 맥스군집의 방향
                    bugList.add(new int[]{tempX,tempY,tempS,tempD});
                }
                tempMap.clear();
            }
            while(!bugList.isEmpty()){
                result += bugList.poll()[2];
            }
            System.out.println("#"+t+" "+result);
        }
    }   
}
