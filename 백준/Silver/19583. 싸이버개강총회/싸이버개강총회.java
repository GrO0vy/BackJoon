import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = calTime(st.nextToken());
        int end = calTime(st.nextToken());
        int sEnd = calTime(st.nextToken());
        int answer = 0;

        HashSet<String> set = new HashSet<>();

        while(true){
            String input = br.readLine();
            if(input == null || "".equals(input)) break;

            st = new StringTokenizer(input);
            int curTime = calTime(st.nextToken());
            String stu = st.nextToken();

            if(curTime <= start) set.add(stu);

            if(set.contains(stu) && curTime >= end && curTime <= sEnd){
                answer++;
                set.remove(stu);
            }
        }

        System.out.println(answer);
    }

    static int calTime(String str){
        String[] time = str.split(":");

        return 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);
    }
}