package d0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5648_원자소멸시뮬레이션_최태선 {
    static int [] di = {1,-1,0,0};
    static int [] dj = {0,0,-1,1};
    static int N,K;
    static int totalEnergy;
    static List<int[]> elementArray;
    static Map<Integer,Integer> status;
    static Set<Integer> removeIdx;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        status = new HashMap<>();
        removeIdx = new HashSet<>();

        for(int t=0;t<T;t++){
            elementArray = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            totalEnergy = 0;
            status.clear();
            removeIdx.clear();
            for(int n=0;n<N;n++){
                st = new StringTokenizer(br.readLine()," ");
                int j = Integer.parseInt(st.nextToken())*2 + 2000; // j번 원자의 x 위치 *2  (.5초마다 안하고 1초마다하려고) + 2000하면 음수값도 index로 처리가능
                int i = Integer.parseInt(st.nextToken())*2 + 2000; // i번 원자의 y 위치
                int d = Integer.parseInt(st.nextToken()); // i번 원자의 방향 d
                int k = Integer.parseInt(st.nextToken()); // i번 원자의 보유에너지 K
                elementArray.add(new int[]{i,j,d,k}); // y x d 값
            }
            // 0.5초마다 시뮬레이션 해야함 -> 그냥 거리를 두배로 늘리고 1초마다 해버릴까?
            for(int p=0;p<4001 && !elementArray.isEmpty();p++){
                status.clear();
                removeIdx.clear();
                tick();
                for (int mapKey : removeIdx) {
                    totalEnergy += status.get(mapKey);
                }
                if(!removeIdx.isEmpty()){
                    Iterator<int[]>it1 = elementArray.iterator();
                    while(it1.hasNext()){
                        int[] e = it1.next();
                        int mapKey = key(e[0],e[1]);
                        if (removeIdx.contains(mapKey)){
                            it1.remove();
                        }
                    }
                }

            }
            
            System.out.println("#"+(t+1) + " " +totalEnergy);
        }
        
    }

    static int key(int i, int j) {
        return i*10000 +j ;
    }
    static void tick(){
        Iterator<int[]> it = elementArray.iterator();
        while (it.hasNext()){
            int[] element = it.next();
            element[0] += di[element[2]];
            element[1] += dj[element[2]];
            if (element[0] < 0 || element[0] > 4000 || element[1] < 0 || element[1] > 4000) {
                it.remove();
                continue;
            }
            int mapKey = key(element[0], element[1]);
            if(status.containsKey(mapKey)){
                status.put(mapKey,status.get(mapKey)+element[3]);
                removeIdx.add(mapKey);
            }
            else{
                status.put(mapKey,element[3]);
            }
        }
    }
}
