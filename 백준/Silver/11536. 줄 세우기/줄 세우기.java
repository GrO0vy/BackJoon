// 1. 첫 번 째 선수와 두 번 째 선수를 compare 한 결과를 저장
// 2. 두 번 째 선수부터 N - 1 번 째 선수까지 i 번째와 i + 1 번째 선수를 compare 한다
// 3. compare 한 결과가 기존 compare 결과와 같으면 계속 진행
// 4. compare 한 결과가 기존 compare 결과와 다르면 NEITHER 출력후 반복 종료
// 5. NEITHER 이 아닐 때 compare 결과가 -1 이면 INCREASING, 1 이면 DECREASING 출력

import java.io.*;
import java.util.*;

public class Main{
    static final String INCREASING = "INCREASING";
    static final String DECREASING = "DECREASING";
    static final String NEITHER = "NEITHER";
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] people = new String[N];
        for(int i = 0; i < N; i++){
            people[i] = br.readLine();
        }
        
        int order = people[0].compareTo(people[1]);
        for(int i = 1; i < N - 1; i++){
            if(order > 0 && people[i].compareTo(people[i + 1]) < 0 || order < 0 && people[i].compareTo(people[i + 1]) > 0){
                System.out.println(NEITHER);
                return;
            }    
        }
        
        if(order < 0) System.out.println(INCREASING);
        else System.out.println(DECREASING);
    }
}