import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        HashSet<Integer> set= new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        
        if(set.size() == 1) answer = 1111 * a;
        else if (set.size() == 2){
            for(int num : set){
                if(Collections.frequency(list,num) == 2){
                    answer = (Collections.min(set) + Collections.max(set) )*
                        Math.abs(Collections.min(set) - Collections.max(set));
                    return answer;
                }
                else{
                    if(Collections.frequency(list,num) == 3){
                        answer += 10 * num;     
                    }
                    if(Collections.frequency(list,num) == 1){
                        answer += num;
                    }
                }
            }
            answer = (int) Math.pow(answer,2);
        }
        else if(set.size() == 3){
            answer = 1;
            
            for(int num : set){
                if(Collections.frequency(list,num) == 1){
                    answer *= num;
                }
            }
        }
        else if(set.size() == 4){
            answer = Collections.min(set);
        }
        return answer;
    }
}