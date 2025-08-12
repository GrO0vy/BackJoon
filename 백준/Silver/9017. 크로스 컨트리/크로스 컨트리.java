import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int cntPeople = Integer.parseInt(br.readLine());

            List<List<Integer>> teamScore = new ArrayList<>();
            for(int j = 0; j <= cntPeople; j++) teamScore.add(new ArrayList<>());

            int[] scores = new int[cntPeople];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < cntPeople; j++){
                scores[j] = Integer.parseInt(st.nextToken());
                teamScore.get(scores[j]).add(j);
            }

            int score = 1;
            for(int j = 0; j < cntPeople; j++){
                if(teamScore.get(scores[j]).size() == 6) scores[j] = score++;
            }

            int winnerTeam = 0;
            int minScore = Integer.MAX_VALUE;

            for(int j = 1; j <= cntPeople; j++){
                List<Integer> team = teamScore.get(j);

                if(team.size() < 6) continue;

                int total = 0;
                for(int k = 0; k < 4; k++){
                    total += scores[team.get(k)];
                }

                if(total < minScore || total == minScore && scores[team.get(4)] < scores[teamScore.get(winnerTeam).get(4)]){
                    winnerTeam = j;
                    minScore = total;
                }
            }

            sb.append(winnerTeam + "\n");
        }

        System.out.println(sb.toString());
    }
}