import java.io.*;
import java.util.*;

public class Main{
    static List<int[]> matches;
    static int[] score;
    static int cnt = 0;
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new int[N + 1];

        matches = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int stat = Integer.parseInt(st.nextToken());

            if(stat == 0) matches.add(new int[]{t1, t2});
            else if(stat == 1) score[t1]++;
            else score[t2]++;
        }

        search(0, score, 0);

        System.out.println(cnt);
    }

    static void search(int matchNum, int[] score, int maxIdx){
        if(matchNum == matches.size()){
            if(score[K] > score[maxIdx]) cnt++;
        }
        else{
            int[] match = matches.get(matchNum);
            score[match[0]]++;
            if(match[0] != K && score[match[0]] > score[maxIdx]) search(matchNum + 1, score, match[0]);
            else search(matchNum + 1, score, maxIdx);
            score[match[0]]--;

            score[match[1]]++;
            if(match[1] != K && score[match[1]] > score[maxIdx]) search(matchNum + 1, score, match[1]);
            else search(matchNum + 1, score, maxIdx);
            score[match[1]]--;
        }
    }
}