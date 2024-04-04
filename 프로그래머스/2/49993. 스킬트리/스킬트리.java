class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree: skill_trees){
            skill_tree = skill_tree.replaceAll("[^"+ skill +"]", "");
            if(skill.indexOf(skill_tree) == 0) answer++;
        }
        return answer;
    }
}