import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[col -1] == o2[col - 1]) return o2[0] - o1[0];
                else return o1[col - 1] - o2[col - 1];
            }
        });
        
        int[] S = new int[data.length];
        
        for(int i = 0; i < S.length; i++){
            for(int num : data[i]){
                S[i] += num % (i + 1);
            }
        }

        answer = S[row_begin - 1];
        
        for(int i = row_begin; i < row_end; i++){
            answer = answer ^ S[i];
        }
        return answer;
    }
}