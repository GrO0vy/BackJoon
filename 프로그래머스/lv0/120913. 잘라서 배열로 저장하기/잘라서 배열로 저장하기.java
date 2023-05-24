class Solution {
    public String[] solution(String my_str, int n) {
        int size = (int)Math.ceil(my_str.length() / (double)n);
        String[] answer = new String[size];
        for(int i =0; i < size; i++){
            if(my_str.length() -1 < i*n+n) answer[i] = my_str.substring(i*n);
            else answer[i] = my_str.substring(i*n,i*n+n);
        }
        return answer;
    }
}