package m05.d0515;

import java.util.*;

class PG_베스트앨범_최태선 {
    class GenreCount{
        String genre;
        int totalCount;
        GenreCount(String genre,int totalCount){
            this.genre = genre;
            this.totalCount = totalCount;
        }
    }
    Map<String,List<int[]>> songMap;
    PriorityQueue<GenreCount> pq;
    List<Integer> result;
    public int[] solution(String[] genres, int[] plays) {
        songMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->Integer.compare(b.totalCount,a.totalCount));
        result = new ArrayList<>();
        for(int i=0;i<plays.length;i++){
            if(!songMap.containsKey(genres[i]))
                songMap.put(genres[i],new ArrayList<>());
            songMap.get(genres[i]).add(new int[] {i,plays[i]}); // 인덱스, 그에맞는 노래
        }
        for(Map.Entry<String,List<int[]>> entry : songMap.entrySet()){
            String genre = entry.getKey();
            List<int[]> list = entry.getValue();
            Collections.sort(list,(a,b)-> {
                if(a[1] != b[1])
                    return Integer.compare(b[1],a[1]);
                else{
                    return Integer.compare(a[0],b[0]);
                }
            });
            GenreCount gc = new GenreCount(genre,0);
            for(int[] songInfo : list){
                int count = songInfo[1];
                gc.totalCount += count;
            }
            pq.add(gc);
        }
        while(!pq.isEmpty()){
            GenreCount gc = pq.poll();
            String nowGenre = gc.genre;
            List<int[]> nowList = songMap.get(nowGenre);
            if(nowList.size() == 1){
                result.add(nowList.get(0)[0]);
            }else{
                result.add(nowList.get(0)[0]);
                result.add(nowList.get(1)[0]);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}