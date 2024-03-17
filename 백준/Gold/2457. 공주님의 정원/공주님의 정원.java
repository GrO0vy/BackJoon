import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        int[] months = new int[]{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = months[startMonth] + startDay;
            int end = months[endMonth] + endDay;

            flowers[i][0] = start;
            flowers[i][1] = end;
        }

        Arrays.sort(flowers, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int currentEnd = months[3] + 1; // 3월 1일을 일수로 바꾼 값
        int cnt = 0;
        int ptr = 0;

        while(currentEnd <= months[12]){
            boolean find = false;
            int max = currentEnd;

            for(int i = ptr; i < N; i++){
                if(flowers[i][0] > currentEnd) break;

                if(flowers[i][1] > max){
                    find = true;
                    ptr = i + 1;
                    max = flowers[i][1];
                }
            }

            if(!find){
                break;
            }

            currentEnd = max;
            cnt++;
        }

        System.out.println(currentEnd <= months[12] ? 0 : cnt);
    }
}