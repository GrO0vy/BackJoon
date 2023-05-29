class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int numer = 0;
        int denom = 0;
        
        for(int i =1; ; i++){
            if(i % denom1 == 0 && i % denom2 == 0){
                numer = ( numer1 * ( i / denom1 ) ) + ( numer2 * ( i / denom2 ) );
                denom = i;
                break;
            }
        }
        
        int maxDivisor =1;
        
        for(int i =2; i<=numer && i<=denom; i++){
            if(numer % i == 0 && denom % i == 0){
                maxDivisor = i;
            }
        }
        
        answer[0] = numer / maxDivisor;
        answer[1] = denom / maxDivisor;
            
        return answer;
    }
}