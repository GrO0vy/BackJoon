class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        
        for(int i = 0; i < a.length; i++){
            if(i - 1 >= 0) left = Math.min(left, a[i - 1]);
            if(a.length - i < a.length) right = Math.min(right, a[a.length - i]);
            
            leftMin[i] = left;
            rightMin[a.length - i - 1] = right;
        }
        
        for(int i = 0; i < a.length; i++){
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            
            answer++;
        }
        
        return answer;
    }
}