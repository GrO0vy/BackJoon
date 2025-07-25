import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = br.readLine();
        boolean isPossible = true;

        while(!password.equals("end")){
            isPossible = containsVowel(password);

            if(isPossible){
                isPossible = !hasTriple(password);
            }

            if(isPossible){
                isPossible = !hasDoubleLetter(password);
            }

            printResult(isPossible, password);

            password = br.readLine();
        }
    }

    static boolean containsVowel(String password){
        String regex = ".*[a|e|i|o|u].*";
        return password.matches(regex);
    }

    static boolean hasTriple(String password){
        char[] arr = password.toCharArray();
        int left = 0;
        int right = 0;
        int vowel = 0;
        int consonant = 0;

        while(right < arr.length){
            if(isVowel(arr[right++])){
                vowel++;
            }
            else consonant++;

            if(vowel + consonant > 3){
                if(isVowel(arr[left++])){
                    vowel--;
                }
                else{
                    consonant--;
                }
            }

            if(consonant == 3 || vowel == 3){
                return true;
            }
        }

        return false;
    }

    static boolean hasDoubleLetter(String password){
        char[] arr = password.toCharArray();

        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] == arr[i] && (arr[i] != 'e' && arr[i] != 'o')){
                return true;
            }
        }

        return false;
    }

    static void printResult(boolean isPossible, String password){
        if(isPossible) System.out.printf("<%s> is acceptable.\n", password);
        else System.out.printf("<%s> is not acceptable.\n", password);
    }

    static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u';
    }
}