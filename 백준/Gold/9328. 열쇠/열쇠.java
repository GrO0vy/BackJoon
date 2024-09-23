import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, K, T;
    public static int answer = 0;
    public static int[] arr;
    public static char[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int h = 0, w = 0;
    public static int[][] visited;
    public static int key;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        T = Integer.parseInt(st.nextToken());

        while(T-- > 0) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h+2][w+2];
            for(int i=1;i<=h;i++) {
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                for(int j=1; j<=w;j++) {
                    map[i][j] = input.charAt(j-1);
                }

            }
            key = 0;
            st = new StringTokenizer(br.readLine());
            String inputKey = st.nextToken();
            for(int i=0;i<inputKey.length();i++) {
                key |= (1 << inputKey.charAt(i) - 'a'); //비트마스킹.
            }
            BFS();
            System.out.println(answer);
        }
    }

    public static void BFS() {
        Queue<Node> q = new LinkedList<>();
        //Map의 Size가 map[h+2][w+2] 이므로 아무데서나 시작해도 괜찮다.
        visited = new int[h+2][w+2];
        visited[0][0] = key;
        q.offer(new Node(0, 0));
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nr = temp.r + dx[dir];
                int nc = temp.c + dy[dir];

                if(nr < 0 || nr > h + 1 || nc < 0 || nc > w + 1 ) continue;
                if(map[nr][nc] == '*') continue;

                if(visited[nr][nc] == key) continue;
                if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
                    boolean flag = (key & (1 << map[nr][nc] - 'A')) > 0; //만약 0 이라면 key가 없는것입니다.
                    if(flag == false) { //만약 key가 없는경우라면 continue
                        continue;
                    }
                }
                else if(map[nr][nc] >= 'a' && map[nr][nc] <='z') { //만약 소문자라면 key값입니다.
                    key |= (1 << map[nr][nc] - 'a');
                }
                else if(map[nr][nc] =='$')
                    answer += 1;

                map[nr][nc] = '.'; //방문한곳은 . 로 바꿔놓습니다.
                visited[nr][nc] = key;
                q.offer(new Node(nr, nc));
            }
        }
    }
}


class Node{
    int r;
    int c;
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}