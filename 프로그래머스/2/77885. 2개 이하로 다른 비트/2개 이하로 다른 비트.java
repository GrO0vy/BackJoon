class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            answer[i] = cal(numbers[i]);
        }
        
        return answer;
    }
    
    long cal(long num){
        String numStr = Long.toBinaryString(num);
        String targetStr = new StringBuilder(numStr).reverse().toString();
        
        if(num % 2 == 0) targetStr = targetStr.replaceFirst("0", "1");
        
        else{
            if(!numStr.contains("0"))
                targetStr = targetStr.substring(0, numStr.length() - 1) + "01";
            else
                targetStr = targetStr.replaceFirst("10", "01");
        }
        
        targetStr = new StringBuilder(targetStr).reverse().toString();
        
        return Long.parseLong(targetStr, 2);
    }
}