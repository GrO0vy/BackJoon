import java.util.*;

class Solution {
    HashMap<String, Integer> idxMap;
    HashMap<String, List<String>> adjMap;
    HashMap<String, List<Integer>> sellMap;
    String[] referral;
    int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        
        idxMap = new HashMap<>();
        adjMap = new HashMap<>();
        sellMap = new HashMap<>();
        this.referral = referral;
        
        List<String> noReferral = new ArrayList<>();
        
        for(int i = 0; i < enroll.length; i++){
            idxMap.put(enroll[i], i);
            sellMap.put(enroll[i], new ArrayList<>());
            adjMap.put(enroll[i], new ArrayList<>());
            
            if(!referral[i].equals("-")){
                adjMap.get(referral[i]).add(enroll[i]);
            }
            else noReferral.add(enroll[i]);
        }
        
        for(int i = 0; i < seller.length; i++){
            sellMap.get(seller[i]).add(amount[i] * 100);
        }
        
        for(String start: noReferral){
            dfs(start);    
        }
        
        return answer;
    }
    
    void dfs(String person){
        int idx = idxMap.get(person);
        List<Integer> sells = sellMap.get(person);
        
        for(String child: adjMap.get(person)){
            dfs(child);
        }
        
        for(int sell: sells){
            repayment(idx, (int)(sell * 0.1));
            answer[idx] += sell - (int)(sell * 0.1);    
        }
    }
    
    void repayment(int child, int addition){
        if(referral[child].equals("-") || addition == 0) return;
        
        int parent = idxMap.get(referral[child]);
        
        answer[parent] += addition - (int)(addition * 0.1);
        
        repayment(parent, (int)(addition * 0.1));
    }
}