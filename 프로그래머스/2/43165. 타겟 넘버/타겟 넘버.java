class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    void dfs(int[] numbers, int target, int idx, int currentSum){
        if(idx == numbers.length) {
            if(currentSum == target) answer++;
            else return;
        }
        else{
            dfs(numbers, target, idx + 1, currentSum + numbers[idx]);
            dfs(numbers, target, idx + 1, currentSum - numbers[idx]);
        }
    }
}