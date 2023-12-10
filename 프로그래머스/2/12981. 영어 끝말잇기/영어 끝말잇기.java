import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            String word = words[i];
            String prev = list.get(list.size() - 1);

            if(prev.charAt(prev.length() - 1) == word.charAt(0) && !list.contains(word)) list.add(word);
            else{
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        
        return answer;
    }
}