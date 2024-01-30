import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < str1.length() - 1; i++){
            String str = str1.substring(i, i + 2);
            str = str.replaceAll("[^a-z|A-Z]", "");
            str = str.toUpperCase();
            
            if(str.length() < 2) continue;
            
            map1.put(str, map1.getOrDefault(str, 0) + 1);
            set.add(str);
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String str = str2.substring(i, i + 2);
            str = str.replaceAll("[^a-zA-Z]", "");
            str = str.toUpperCase();
            
            if(str.length() < 2) continue;
            
            map2.put(str, map2.getOrDefault(str, 0) + 1);
            set.add(str);
        }
        
        int unionCnt = 0;
        int interCnt = 0;
        
        for(String str: set){
            int cnt1 = map1.getOrDefault(str, 0);
            int cnt2 = map2.getOrDefault(str, 0);
            
            unionCnt += Math.max(cnt1, cnt2);
            interCnt += Math.min(cnt1, cnt2);
        }
      
        answer = unionCnt == 0 ? 65536 : (int)(interCnt / (double)unionCnt * 65536);
        return answer;
    }
}