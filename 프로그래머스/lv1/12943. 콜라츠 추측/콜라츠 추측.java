class Solution {
    public int solution(int num) {
        int cnt = 0;
        long result = num;
        while(result != 1){
            result = (result % 2 == 0) ? result / 2 : result * 3 + 1;
            cnt++;
            if(cnt > 500) return -1;
        }
        return cnt;
    }
}