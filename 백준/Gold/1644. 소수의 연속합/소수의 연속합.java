import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean check[] = new boolean[n+1];
        ArrayList<Integer> primes = new ArrayList<>();

        // 소수가 아니면 true로
        check[0] = check[1] = true;

        for(int i=2; i <= Math.sqrt(check.length); i++){
            for(int j=i*i; j<=n; j+=i){
                if(!check[j]) check[j] = true;
            }
        }
        for(int i=0; i<=n; i++){
            if(!check[i]) primes.add(i); // 소수 넣기
        }

        int sum = 0, left = 0, answer = 0;

        for(int right = 0; right<n; right++){
            if(right >= primes.size()) continue;

            sum += primes.get(right);

            if(sum == n) answer++;

            while(sum >= n && left >=0){ // sum 보다 같거나 작으면 left인덱스 증가해 해당 값 빼줌
                sum -= primes.get(left++);
                if(sum == n) answer++;
            }
        }
        System.out.println(answer);


    }
}