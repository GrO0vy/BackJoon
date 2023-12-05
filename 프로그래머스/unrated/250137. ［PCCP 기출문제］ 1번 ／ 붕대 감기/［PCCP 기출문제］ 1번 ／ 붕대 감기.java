import java.util.HashMap;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int maxCombo = bandage[0];
        int heal = bandage[1];
        int bonus = bandage[2];
        int combo = 1;
        int lastTime = attacks[attacks.length - 1][0];
        
        
        HashMap<Integer, Integer> attack = new HashMap<>();
        for(int[] att: attacks){
            attack.put(att[0], att[1]);    
        }
            
        for(int i = 1; i <= lastTime; i++){
            if(!attack.containsKey(i)){
                if(combo == maxCombo) {
                    currentHealth += bonus + heal;
                    combo = 1;
                }
                else {
                    currentHealth += heal;
                    combo++;
                }
                
                if(currentHealth > health) currentHealth = health;
            }
            else{
                currentHealth -= attack.get(i);
                if(currentHealth <= 0) return -1;
                combo = 1;
            }
        }
        
        return currentHealth;
    }
}