class Solution {
    int[] answer;
    int cntEmo;
    int cntUser;
     
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        cntEmo = emoticons.length;
        cntUser = users.length;
    
        int[] discount = new int[cntEmo];
        
        dfs(0, discount, emoticons, users);
        
        return answer;
    }
    
    void dfs(int idx, int[] discount, int[] emoticons, int[][] users){
        if(idx == cntEmo) calculation(discount, emoticons, users);
        else{
            for(int i = 10; i <= 40; i += 10){
                discount[idx] = i;
                dfs(idx + 1, discount, emoticons, users);
            }        
        }
    }
    
    void calculation(int[] discount, int[] emoticons, int[][] users){
        int totalPrice = 0;
        int subscriber = 0;
        
        for(int[] user: users){
            int price = 0;
            for(int i = 0; i < cntEmo; i++){
                if(discount[i] >= user[0]) 
                    price += emoticons[i] * (100 - discount[i]) / 100.0;
            }
            
            if(price >= user[1]) subscriber++;
            else totalPrice += price;
        }
        
        if(subscriber > answer[0] || subscriber == answer[0] && totalPrice > answer[1]){
            answer[0] = subscriber;
            answer[1] = totalPrice;
        }
    }
}