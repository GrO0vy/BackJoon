import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String target = br.readLine();

        int cnt = 0;
        while(document.contains(target)){
            document = document.replaceFirst(target, "@");
            cnt++;
        }

        System.out.println(cnt);
    }
}