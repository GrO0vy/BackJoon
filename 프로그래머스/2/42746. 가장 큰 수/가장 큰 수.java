import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] arr = new Integer[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = numbers[i];
        }
        
        Arrays.sort(arr, new Comparator<>(){
            public int compare(Integer o1, Integer o2){
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);
                
                int result1 = Integer.parseInt(str1+str2);
                int result2 = Integer.parseInt(str2+str1);
                
                return result2 - result1;
            }
        });
        
        for(int i = 0; i < arr.length; i++)
            answer += arr[i] + "";
        
        if(answer.charAt(0) == '0') answer = "0";
        
        return answer;
    }
}