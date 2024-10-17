import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String target = br.readLine();
        String newDoc = document.replace(target, "");
        
        System.out.println((document.length() - newDoc.length())/ target.length());
    }
}