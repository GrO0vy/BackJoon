import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int cntZero = 0;
        int cntOne = 0;

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0') cntZero++;
            else cntOne++;
        }

        int halfZero = cntZero / 2;
        int halfOne = cntOne / 2;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0'){
                if(cntZero > halfZero){
                    sb.append('0');
                }
                cntZero--;
            }
            else{
                if(cntOne <= halfOne){
                    sb.append('1');
                }

                cntOne--;
            }
        }

        System.out.println(sb.toString());
    }
}