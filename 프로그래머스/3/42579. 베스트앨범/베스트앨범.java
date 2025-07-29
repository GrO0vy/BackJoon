import java.util.*;

class Solution {
    int[] plays;
    public int[] solution(String[] genres, int[] plays) {
        this.plays = plays;
        
        Map<String, Genre> map = new HashMap<>();
        List<Genre> list = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            String category = genres[i];
            int cntPlay = plays[i];
            
            if(!map.containsKey(category)) {
                Genre genre = new Genre();
                map.put(category, genre);
                list.add(genre);
            }
            
            Genre genre = map.get(category);
            PriorityQueue<Integer> musics = genre.musics;
            
            musics.offer(i);
            genre.cntTotal += cntPlay;
        }
        
        Collections.sort(list, (o1, o2) -> o2.cntTotal - o1.cntTotal);
        
        List<Integer> result = new ArrayList<>();
        for(Genre genre: list){
            int cnt = 0;
            while(!genre.musics.isEmpty() && cnt < 2){
                result.add(genre.musics.poll());
                cnt++;
            }
        }
        
        
        return result.stream().mapToInt(i->i).toArray();
    }
    
    class Genre{
        PriorityQueue<Integer> musics;
        int cntTotal;
        
        public Genre(){
            musics = new PriorityQueue<>((o1, o2) -> plays[o2] - plays[o1]);
        }
    }
}