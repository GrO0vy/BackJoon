import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++){
            String str1 = br.readLine();
            String str2 = br.readLine();

            String message = "";
            if(format(str1).equals(format(str2))) message = String.format("Data Set %d: equal\n", i + 1);
            else message = String.format("Data Set %d: not equal\n", i + 1);

            sb.append(message + "\n");
        }

        System.out.println(sb);
    }

    static String format(String str){
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", " ");
        str = str.trim();
        str = str.replaceAll("\\{|\\[", "(");
        str = str.replaceAll("}|]", ")");
        str = str.replaceAll(";", ",");

        String result = "";
        int idx = 0;

        for(int i = 1; i < str.length() - 1; i++){
            if(str.charAt(i) == ' '){
                if(str.charAt(i - 1) > 'z' || str.charAt(i - 1) < 'a' || str.charAt(i + 1) > 'z' || str.charAt(i + 1) < 'a') {
                    result += str.substring(idx, i);
                    idx = i + 1;
                }
            }
        }

        result += str.substring(idx);

        return result;
    }
}