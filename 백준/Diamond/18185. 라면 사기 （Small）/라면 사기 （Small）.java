// 1. 현재 위치 ~ 현재 위치 + 2 까지 셋 중 가장 작은 값을 각각에 빼준다.
// 2. 전체 비용에 7 * 가장 작은 값을 더한다.
// 3. 현재 위치 ~ 현재 위치 + 1 까지 가장 작은 값을 각각에 빼준다.
// 4. 전제 비용에 5 * 가장 작은 값을 더한다.
// 5. 현재 위치에 남은 값 * 3 을 전체 비용에 더한다.

import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int[] factories;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        factories = new int[N + 3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) factories[i] = Integer.parseInt(st.nextToken());

        int totalCost = 0;
        for(int i = 1; i <= N; i++){
            if(factories[i] == 0) continue;
            
            int cycle = 0;
            if(factories[i + 1] > factories[i + 2]){
                cycle = Math.min(factories[i], factories[i + 1] - factories[i + 2]);
                factories[i] -= cycle;
                factories[i + 1] -= cycle;

                totalCost += cycle * 5;

                cycle = Math.min(factories[i], Math.min(factories[i + 1], factories[i + 2]));
                factories[i] -= cycle;
                factories[i + 1] -= cycle;
                factories[i + 2] -= cycle;

                totalCost += 7 * cycle;
            }

            else{
                cycle = Math.min(factories[i], factories[i + 1]);
                factories[i] -= cycle;
                factories[i + 1] -= cycle;
                factories[i + 2] -= cycle;

                totalCost += 7 * cycle;

                cycle = Math.min(factories[i], factories[i + 1]);
                factories[i] -= cycle;
                factories[i + 1] -= cycle;
                totalCost += cycle * 5;
            }

            totalCost += factories[i] * 3;
        }

        System.out.println(totalCost);
    }
}