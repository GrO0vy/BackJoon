// 1. 포인터를 선언
// 2. 문자 개수를 저장할 배열 선언
// 3. 포인터가 가리키는 문자의 개수를 1증가 시키고 3의 배수가 아니면 계속 진행
// 4. 포인터가 가리키는 문자의 개수가 3의 배수이면 포인터가 끝에 도달했는지와 다음 위치의 문자와 같은지 판단
// 5. 끝 위치가 아니고 다음 위치의 문자와 같다면 포인터를 1칸 이동
// 6. 그렇지 않으면 return false
// 7. 포인터를 1이동

import java.io.*;
import java.util.*;

public class Main{
    static final String VALIDATE = "OK";
    static final String NOT_VALIDATE = "FAKE";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            if(isValidate(br.readLine())) sb.append(VALIDATE + "\n");
            else sb.append(NOT_VALIDATE + "\n");
        }

        System.out.println(sb.toString());
    }

    static boolean isValidate(String password){
        int[] cntLetter = new int[26];

        for(int i = 0; i < password.length(); i++){
            int idx = password.charAt(i) - 'A';
            cntLetter[idx]++;

            if(cntLetter[idx] % 3 == 0){
                if(i != password.length() - 1 && password.charAt(i) == password.charAt(i + 1)){
                    i++;
                }
                else return false;
            }
        }

        return true;
    }
}