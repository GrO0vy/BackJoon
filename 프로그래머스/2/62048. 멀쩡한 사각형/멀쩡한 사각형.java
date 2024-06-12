class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        if(w == 1 || h == 1) return 0;
        
        int maxDivider;
        if(w > h) maxDivider = gcd(w, h);
        else maxDivider = gcd(h, w);
        
        answer = (long)w * h - (w / maxDivider + h / maxDivider - 1) * maxDivider;
        
        return answer;
    }
    
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}