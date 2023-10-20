import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s=1,e=1;
        long now=1;
        long ans=0;

        while (e < n) {
            if (now <= n) {
                now += e + 1;
                e++;
            } else {
                now -= s;
                s++;
            }
            if (now == n) ans++;
        }
        System.out.println(ans+1);
    }
}