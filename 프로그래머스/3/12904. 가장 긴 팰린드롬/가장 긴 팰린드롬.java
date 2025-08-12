class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for(int i = 0; i < s.length() - 1; i++){
            answer = Math.max(answer, findLongestPalindrome(s, i, i + 1));
            answer = Math.max(answer, findLongestPalindrome(s, i, i));
        }

        return answer;
    }
    
    int findLongestPalindrome(String s, int left, int right){
        int length = 0;
        
        while(0 <= left && right < s.length()){
            if(s.charAt(left) != s.charAt(right)) break;
            
            length = right - left + 1;
            
            left--;
            right++;
        }

        return length;
    }
}