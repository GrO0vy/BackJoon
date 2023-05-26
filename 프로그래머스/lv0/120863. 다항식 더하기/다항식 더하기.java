class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int num = 0;
        String[] terms = polynomial.split("\\+");
        
        for(int i = 0; i < terms.length; i++){
            String str = terms[i].trim();
            if(str.contains("x")){
                if(str.length() == 1) str = "1"+str;
                x += Integer.valueOf(str.substring(0,str.length()-1));    
            } 
            else num += Integer.valueOf(str);
        }
        
        if(x == 1) answer = "x";
        else if(x > 0) answer = String.format("%dx",x);
        
        if(x == 0) answer += String.valueOf(num);
        else answer += ( num == 0 ?  "" : String.format(" + %d",num) );
        
        
        return answer;
    }
}