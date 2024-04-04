import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        FileName[] names = new FileName[files.length];
        
        for(int i = 0; i < files.length; i++){
            String head = files[i].split("[0-9]")[0];
            files[i] = files[i].replaceFirst(head, "");
            String number = files[i].split("[^0-9]")[0];
            String tail = files[i].replaceFirst(number, "");
            
            names[i] = new FileName(head, number, tail);
        }
        
        Arrays.sort(names, new Comparator<>(){
            public int compare(FileName o1, FileName o2){
                String head1 = o1.head.toUpperCase();
                String head2 = o2.head.toUpperCase();
                
                if(head1.compareTo(head2) != 0) return head1.compareTo(head2); 
                
                int number1 = Integer.parseInt(o1.number);
                int number2 = Integer.parseInt(o2.number);
                
                if(number1 != number2) return number1 - number2;
                
                return 0;
            }    
        });
        
        answer = new String[names.length];
        for(int i = 0; i < names.length; i++){
            answer[i] = names[i].printString();
        }
        
        return answer;
    }
    
    class FileName{
        String head = "";
        String number = "";
        String tail = "";
        
        public FileName(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public String printString(){
            return String.format("%s%s%s", head, number, tail);
        }
    }
}