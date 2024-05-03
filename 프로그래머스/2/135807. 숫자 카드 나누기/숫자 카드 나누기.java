import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if(isAllImpossible(gcdA, arrayB)) answer = Math.max(answer, gcdA);
        if(isAllImpossible(gcdB, arrayA)) answer = Math.max(answer, gcdB);
        
        return answer;
    }
    
    int gcd(int a, int b){
        if(a % b == 0) return b;
        else return gcd(b, a % b);
    }
    
    boolean isAllImpossible(int gcd, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % gcd == 0) return false;
        }
        
        return true;
    }
}