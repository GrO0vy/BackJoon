class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String base = "";
        int num = 0;
        while(base.length() < m * t){
            base += tenToN(num, n);
            num++;
        }

        for(int i = 0; answer.length() < t; i += m){
            answer += base.charAt(i + p - 1) + "";
        }
        
        return answer;
    }
    
    public String tenToN(int decimal, int n){
        String base = "";
        while(decimal >= n){
            int next = decimal % n;
            
            if(next >= 10) base = (char)(next + 55) + base;
            else base = ( decimal % n ) + base;
            decimal /= n;
        }
        
        return decimal >= 10 ? (char)(decimal + 55) + base : decimal + base;
    }
}