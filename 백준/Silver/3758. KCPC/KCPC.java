import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            Map<Integer, Team> teams = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());

                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if(!teams.containsKey(teamId)) teams.put(teamId, new Team(teamId, k));

                Team team = teams.get(teamId);
                team.lastTime = j;
                team.cntSubmit++;

                if(team.solved[problemId] < score){
                    team.score -= team.solved[problemId];
                    team.score += score;
                    team.solved[problemId] = score;
                }
            }

            List<Team> sorted = new ArrayList<>(teams.values());
            Collections.sort(sorted, new Comparator<>(){
                public int compare(Team o1, Team o2){
                    if(o1.score != o2.score) return o2.score - o1.score;
                    if(o1.cntSubmit != o2.cntSubmit) return o1.cntSubmit - o2.cntSubmit;
                    return o1.lastTime - o2.lastTime;
                }
            });

            for(int j = 0; j < n; j++){
                if(sorted.get(j).teamId == t){
                    sb.append((j + 1) + "\n");
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }

    static class Team{
        int teamId;
        int score;
        int cntSubmit;
        int lastTime;
        int[] solved;

        public Team(int teamId, int cntProblem){
            this.teamId = teamId;
            this.solved = new int[cntProblem + 1];
        }
    }
}