import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntSwitch = Integer.parseInt(br.readLine());

        int[] switches = new int[cntSwitch + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= cntSwitch; i++) switches[i] = Integer.parseInt(st.nextToken());

        int cntStudent = Integer.parseInt(br.readLine());

        for(int i = 0; i < cntStudent; i++){
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            OperateSwitch(switches, gender, number);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cntSwitch; i++){
            sb.append(switches[i] + " ");
            if(i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void OperateSwitch(int[] switches, int gender, int number){
        if(gender == 1){
            for(int i = number; i < switches.length; i += number){
                switches[i] = switches[i] == 1 ? 0 : 1;
            }
        }
        else{
            for(int i = 0; 0 < number - i && number + i < switches.length; i++){
                if(switches[number - i] != switches[number + i]) break;

                switches[number - i] = switches[number - i] == 1 ? 0 : 1;
                switches[number + i] = switches[number - i];
            }
        }
    }
}