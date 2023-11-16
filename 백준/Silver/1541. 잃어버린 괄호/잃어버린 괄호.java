import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exps = br.readLine().split("-");

        int result = 0;
        for(int i = 0; i < exps.length; i++){
            int sum = mySum(exps[i]);
            if(i == 0) result += sum;
            else result -= sum;
        }

        System.out.println(result);
    }

    static int mySum(String str){
        int sum = 0;
        for(String num: str.split("[+]")) sum += Integer.parseInt(num);
        return sum;
    }
}