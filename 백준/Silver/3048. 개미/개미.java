// 1. 개미 클래스를 만든다. ( 문자값, 방향값을 가짐 )
// 2. 첫번째 문자열은 뒤집어서, 두번째 문자열은 정방향으로해서 개미 배열에 차례로 집어넣는다.
// 3. T초만큼 방향이 다른 개미끼리 인접한 부분을 스왑한다.
// 4. 최종적으로 개미 배열의 문자 값만 차례로 추출해서 문자열을 만들어 결과를 출력한다.

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        String group1 = br.readLine();
        String group2 = br.readLine();
        int T = Integer.parseInt(br.readLine());

        Ant[] ants = new Ant[N1 + N2];
        int idx = 0;

        for(int i = N1 - 1; i >= 0; i--){
            ants[idx++] = new Ant(group1.charAt(i), 1);
        }

        for(int i = 0; i < N2; i++){
            ants[idx++] = new Ant(group2.charAt(i), -1);
        }

        for(int i = 0; i < T; i++){
            move(ants);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ants.length; i++){
            sb.append(ants[i].value);
        }

        System.out.println(sb.toString());
    }

    static void move(Ant[] ants){
        for(int i = 0; i < ants.length - 1; i++){
            if(ants[i].dir == 1 && ants[i].dir != ants[i + 1].dir){
                Ant temp = ants[i];
                ants[i] = ants[i + 1];
                ants[i + 1] = temp;

                i++;
            }
        }
    }

    static class Ant{
        char value;
        int dir;

        public Ant(char value, int dir){
            this.value = value;
            this.dir = dir;
        }
    }
}