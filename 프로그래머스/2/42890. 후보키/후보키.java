import java.util.*;

class Solution {
    int answer = 0;
    int col;
    int row;
    boolean[] selected;
    List<HashSet<Integer>> candidateKeys;
    
    public int solution(String[][] relation) {
        candidateKeys = new ArrayList<>();
        row = relation.length;
        col = relation[0].length;
        selected = new boolean[relation[0].length];
        
        makeSubset(0, relation);
        return answer;
    }
    
    void makeSubset(int idx, String[][] relation){
        if(idx >= col){
            if(isCandidate(relation)) answer++;
        }
        else{
            selected[idx] = false;
            makeSubset(idx + 1, relation);
            selected[idx] = true;
            makeSubset(idx + 1, relation);
        }
    }
    
    boolean isCandidate(String[][] relation){
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < row; i++){
            String data = "";
            for(int j = 0; j < col; j++){
                if(selected[j]) data += relation[i][j];
            }
            
            set.add(data);
        }
        
        if(set.size() == row){
            if(isMinimal()) return true;    
        }
        
        return false;
    }
    
    boolean isMinimal(){
        HashSet<Integer> now = new HashSet<>();
        for(int i = 0; i < col; i++) if(selected[i]) now.add(i);
        
        for(HashSet<Integer> candi: candidateKeys){
            if(now.containsAll(candi)) return false;
        }
        
        candidateKeys.add(now);
        return true;
    }
}