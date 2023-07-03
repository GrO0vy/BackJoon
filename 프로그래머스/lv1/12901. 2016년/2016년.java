class Solution {
    public String solution(int a, int b) {
        int[] days = {0,31,29,31,30,31,30,31,31,30,31,30};
        int totalDays = 0;
        
        for(int i = 0; i < a; i++){
            totalDays += days[i];
        }
        
        totalDays += b;
        
        switch(totalDays % 7){
            case 1 : return "FRI";
            case 2 : return "SAT";
            case 3 : return "SUN";
            case 4 : return "MON";
            case 5 : return "TUE";
            case 6 : return "WED";
            case 0 : return "THU";
        }
        return null;
    }
}