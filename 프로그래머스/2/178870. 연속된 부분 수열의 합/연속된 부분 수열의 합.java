import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        List<int[]> list = new ArrayList<>();
        
        int len = sequence.length;
        int left = 0;
        int right = 1;
        int sum = sequence[0];
        
        while(left < right){
            if(sum == k){
                list.add(new int[]{left, right - 1});
                sum -= sequence[left++];
            }
            else if(sum > k){
                sum -= sequence[left++];
            }
            else if(sum < k && right < len){
                sum += sequence[right++];
            }
            else break;
        }
        
        Collections.sort(list, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                int len1 = o1[1] - o1[0];
                int len2 = o2[1] - o2[0];
                
                if(len1 == len2) return 0;
                else return len1 - len2;
            }
        });
        
        answer = list.get(0);
        return answer;
    }
}