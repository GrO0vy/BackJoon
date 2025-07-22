import java.util.*;

class Solution { 
    public int solution(String begin, String target, String[] words) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= words.length; i++) adjList.add(new ArrayList<>());
        
        for(int i = 0; i < words.length; i++){
            List<Integer> list = adjList.get(i);
            for(int j = 0; j < words.length; j++){
                if(i == j) continue;
                
                if(isAdjacent(words[i], words[j])) list.add(j);
            }
        }

        for(int i = 0; i < words.length; i++) {
            if(isAdjacent(begin, words[i])) adjList.get(words.length).add(i);
        }
        
        boolean[] visited = new boolean[words.length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{words.length, 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int next: adjList.get(current[0])){
                if(words[next].equals(target)){
                    return current[1] + 1;
                } 
                
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, current[1] + 1});
                }
            }
        }
        
        return 0;
    }
    
    
    private boolean isAdjacent(String word1, String word2){
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        
        int inCorrect = 0;
        
        for(int i = c1.length - 1; i >= 0; i--){
            if(c1[i] != c2[i]){
                inCorrect++;
                if(inCorrect > 1) return false;
            }    
        }
        
        return true;
    }
}