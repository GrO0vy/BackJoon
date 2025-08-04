import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < P; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testNum = Integer.parseInt(st.nextToken());

            List<Integer> students = new ArrayList<>();

            int student = Integer.parseInt(st.nextToken());
            students.add(student);

            int count = 0;

            for(int j = 1; j < 20; j++) {
                student = Integer.parseInt(st.nextToken());

                for(int k = students.size() - 1; k >= -1; k--){
                    if(k == -1 || students.get(k) < student) {
                        count += students.size() - k - 1;
                        students.add(k + 1, student);
                        break;
                    }
                }
            }

            sb.append(String.format("%d %d\n", testNum, count));
        }

        System.out.println(sb.toString());
    }
}