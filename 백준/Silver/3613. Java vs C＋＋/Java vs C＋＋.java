import java.io.*;
import java.util.*;

public class Main{
    static String var;
    static final String ERROR = "Error!";
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var = br.readLine();
        
        if(isError()){
            var = ERROR;  
        }
        else if(isCpp()){
            var = cppToJava();    
        }
        else{
            var = javaToCpp();    
        }
        
        System.out.println(var);
    }
    
    static boolean isError(){
        if(var.length() == 0) return true;
        
        boolean containsUnderBar = var.contains("_");
        boolean containsUpperCase = false;
        
        for(int i = 0; i < var.length(); i++){
            if(Character.isUpperCase(var.charAt(i))){
                containsUpperCase = true;
                break;
            }    
        }
        
        if(containsUnderBar && containsUpperCase) return true;
        
        if(var.contains("__")) return true;
        
        if(var.charAt(0) == '_' || var.charAt(var.length() - 1) == '_') return true;
        
        if(!Character.isLowerCase(var.charAt(0))) return true;
        
        return false;
    }
    
    static boolean isCpp(){
        return var.contains("_");    
    }
    
    static String javaToCpp(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < var.length(); i++){
            if(Character.isUpperCase(var.charAt(i))){
                sb.append("_");
                sb.append(Character.toLowerCase(var.charAt(i)));    
            }
            else sb.append(var.charAt(i));
        }
        
        return sb.toString();
    }
    
    static String cppToJava(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < var.length(); i++){
            if(var.charAt(i) == '_'){
                sb.append(Character.toUpperCase(var.charAt(++i)));    
            }
            else sb.append(var.charAt(i));
        }
        
        return sb.toString();
    }
}