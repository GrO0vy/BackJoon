import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            String str = br.readLine();

            sb.append(palindrome(str,0 , str.length() - 1, 0) + "\n");
        }

        System.out.println(sb);
    }

    static int palindrome(String str, int start, int end, int cntRemove){
        if(cntRemove == 2){
            return 2;
        }

        int left = start;
        int right = end;

        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else{
                return Math.min(palindrome(str, left, right - 1, cntRemove + 1), palindrome(str, left + 1, right, cntRemove + 1));
            }
        }

        return cntRemove;
    }
}