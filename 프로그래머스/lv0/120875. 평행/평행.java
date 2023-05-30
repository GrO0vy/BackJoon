class Solution {
    public int solution(int[][] dots) {
        for(int i=1; i<dots.length; i++){
            double d1 = (double)(dots[0][1] - dots[i][1]) / (dots[0][0] - dots[i][0]);
            double d2 = 0;
            
            for(int j=1; j<dots.length; j++){
                if(j == i) continue;
                
                for(int k = 1; k<dots.length; k++){
                    if(k == i || k == j) continue;
                    else{
                        d2 = (double)(dots[j][1] - dots[k][1]) / (dots[j][0] - dots[k][0]);
                    }
                }
                if(d1 == d2) return 1;
            }
        }
        return 0;
    }
}