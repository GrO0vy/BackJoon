import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        String[] numbers = exp.split("[+|-]");
        char[] op = exp.replaceAll("[0-9]","").toCharArray();

        int result = Integer.parseInt(numbers[0]);

        for(int i = 0; i < op.length; i++){
            if(op[i] == '+') result += Integer.parseInt(numbers[i + 1]);
            else{
                for(int j = i + 1; j < numbers.length; j++) result -= Integer.parseInt(numbers[j]);
                break;
            }
        }

        System.out.println(result);
    }
}