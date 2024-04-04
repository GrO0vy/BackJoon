class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree: skill_trees){
            String notLearn = skill;
            boolean isPossible = true;
            for(int j = 0; j < skill_tree.length(); j++){
                if(notLearn.contains(skill_tree.charAt(j) + "")){
                    if(skill_tree.length() > 0 && 
                       skill_tree.charAt(j) == notLearn.charAt(0))
                        notLearn = notLearn.substring(1);
                    else isPossible = false;
                }
            }
            
            if(isPossible) answer++;
        }
        
        return answer;
    }
}