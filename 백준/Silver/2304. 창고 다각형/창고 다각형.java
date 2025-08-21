import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Column[] columns = new Column[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            columns[i] = new Column(x, y);


        }

        Arrays.sort(columns, (o1, o2) -> o1.x - o2.x);
        int highest = 0;
        for(int i = 0; i < N; i++){
            if(columns[i].y > columns[highest].y){
                highest = i;
            }
        }

        int area = 0;
        // 왼쪽 탐색
        int prevIdx = 0;
        for(int i = 1; i <= highest; i++){
            if(columns[i].y >= columns[prevIdx].y){
                int width = columns[i].x - columns[prevIdx].x;
                int height = columns[prevIdx].y;

                area += width * height;
                prevIdx = i;
            }
        }

        // 오른쪽 탐색
        prevIdx = N - 1;
        for(int i = N - 2; i >= highest; i--){
            if(columns[i].y >= columns[prevIdx].y){
                int width = columns[prevIdx].x - columns[i].x;
                int height = columns[prevIdx].y;

                area += width * height;
                prevIdx = i;
            }
        }

        area += columns[highest].y;
        System.out.println(area);
    }

    static class Column{
        int x;
        int y;

        public Column(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}