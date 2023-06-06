class Solution {
    public String solution(String n_str) {
        if(n_str.charAt(0) == '0') return n_str.replaceFirst("0+","");
        return n_str;
    }
}