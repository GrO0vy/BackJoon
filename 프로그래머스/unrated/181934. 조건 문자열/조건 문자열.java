class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        switch(ineq){
            case ">":
                if(eq.equals("=") ? n >= m : n > m) return 1;
                break;
            case "<":
                if(eq.equals("=") ? n <= m : n < m) return 1;
                break;
        }
        return 0;
    }
}