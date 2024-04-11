import java.util.*;

class Solution {
    HashSet<Integer> set;
    String[] arr;
    int len;
    boolean[] isVisited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        len = numbers.length();
        arr = numbers.split("");
        set = new HashSet<>();
        isVisited = new boolean[len];
        
        for(int i = 0; i < len; i++) dfs("", i, isVisited);
        answer = set.size();

        return answer;
    }
    
    void dfs(String n, int idx, boolean[] isVisited){
        n += arr[idx];
        if(n.length() > len) return;
        
        isVisited[idx] = true;
        int num = Integer.parseInt(n);
        
        if(isPrime(num)) set.add(num);
        
        for(int i = 0; i < len; i++){
            if(!isVisited[i]) {
                dfs(n, i, isVisited);
            }
        }
        
        isVisited[idx] = false;
    }
    
    boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}