import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] scores;
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        scores = new int[N][N];

        min = Integer.MAX_VALUE;

        int total = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                scores[i][j] = Integer.parseInt(st.nextToken());
                total += scores[i][j];
            }
        }

        for(int i = 0; i < N; i++){
            dfs(i, new ArrayList<>(), 0, total, 0);
        }

        System.out.println(min);
    }

    static void dfs(int start, List<Integer> players, int team, int opponent, int count){
        if(count == N / 2){
            min = Math.min(min, Math.abs(team - opponent));
            return;
        }

        for(int i = start; i < N; i++){
            players.add(i);
            int teamScore = team;
            int opponentScore = opponent;

            for(int coworker: players){
                teamScore += scores[i][coworker] + scores[coworker][i];
            }

            for(int j = 0; j < N; j++) {
                if(!players.contains((Integer) j)){
                    opponentScore -= scores[j][i];
                    opponentScore -= scores[i][j];
                }
            }

            dfs(i + 1, players, teamScore, opponentScore, count + 1);

            players.remove(players.size() - 1);
        }
    }
}