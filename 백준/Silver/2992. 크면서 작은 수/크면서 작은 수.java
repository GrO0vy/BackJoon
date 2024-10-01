import java.io.*;

public class Main{
    static int result = Integer.MAX_VALUE;
    static String X;
    static int XInt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = br.readLine();
        XInt = Integer.parseInt(X);

        recur("", new boolean[X.length()]);

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }

    static void recur(String num, boolean[] visited){
        if(num.length() == X.length()){
            int numInt = Integer.parseInt(num);
            if(numInt > XInt) result = Math.min(result, numInt);

            return;
        }

        for(int i = 0; i < X.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            recur(num + X.charAt(i), visited);
            visited[i] = false;
        }
    }
}