import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = Integer.MIN_VALUE;
        
        HashMap<String, Integer> users = new HashMap<>();
        int[][] giftLog = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++){
            users.put(friends[i], i);
        }
        
        for(String gift: gifts){
            String[] log = gift.split(" ");
            String sender = log[0];
            String receiver = log[1];
            
            giftLog[users.get(sender)][users.get(receiver)]++;
            giftScore[users.get(sender)]++;
            giftScore[users.get(receiver)]--;
        }
        
        int[] nextCnt = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++){
            for(int j = i + 1; j < friends.length; j++){
                if(giftLog[i][j] == giftLog[j][i]){
                    if(giftScore[i] > giftScore[j])
                        nextCnt[i]++;
                    else if(giftScore[i] < giftScore[j])
                        nextCnt[j]++;
                    else continue;
                }
                else{
                    if(giftLog[i][j] > giftLog[j][i])
                        nextCnt[i]++;
                    else
                        nextCnt[j]++;
                }
            }
        }
        
        for(int i = 0; i < nextCnt.length; i++){
            answer = Math.max(nextCnt[i], answer);
        }
        return answer;
    }
}