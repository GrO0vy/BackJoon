import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] values = new int[count + 2];

        for(int i = 1; i <= count; i++){
            values[i] = Integer.parseInt(br.readLine());
        }

        int[] score = new int[count + 2];
        score[1] = values[1];
        score[2] = values[1] + values[2];
        for(int i = 3; i <= count; i++){
            score[i] = Math.max(score[i - 3] + values[i - 1], score[i - 2]) + values[i];
        }

        System.out.println(score[count]);
    }
}