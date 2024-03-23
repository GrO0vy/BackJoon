class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    int dfs(int[] numbers, int target, int idx, int currentSum){
        if(idx == numbers.length) {
            if(currentSum == target) return 1;
            else return 0;
        }
        else{
            return dfs(numbers, target, idx + 1, currentSum + numbers[idx]) + dfs(numbers, target, idx + 1, currentSum - numbers[idx]);
        }
    }
}