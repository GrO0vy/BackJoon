import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        int k = Integer.parseInt(str.nextToken());
        long[] line = new long[1000001];
        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            line[s]++;
            line[e]--;
        }
        long[] prefix = new long[1000002];
        for (int i = 0; i < 1000001; i++) {
            prefix[i+1]=prefix[i]+line[i];
        }
        int s = 1;
        int e = 1;
        boolean chk = false;
        long sum = prefix[1]-prefix[0];
        while (true){
            if(sum==k) {chk=true;break;}
            if(sum<k) {
                e++;
                if(e==1000002) break;
                sum+=prefix[e];
                continue;
            }
            if(sum>k) {
                sum-=prefix[s];
                s++;
                if(s==1000002) break;
            }
        }
        if(chk) System.out.println((s-1)+" "+e);
        else System.out.println(0+" "+0);
    }
}