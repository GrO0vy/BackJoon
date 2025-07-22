import java.io.*;

public class Main{
    static String[] channels;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        channels = new String[N];

        for(int i = 0; i < N; i++) channels[i] = br.readLine();

        for(int i = 0; i < N; i++){
            if(channels[i].equals("KBS1") || channels[i].equals("KBS2")){
                i = swap(i);
            }
            else System.out.print(1);
        }
    }

    static int swap(int i){
        while(i > 0 && !channels[i - 1].equals("KBS1")){
            String temp = channels[i];
            channels[i] = channels[i - 1];
            channels[i - 1] = temp;

            i--;

            System.out.print("4");
        }

        if(channels[1].equals("KBS2")) return N;
        else{
            System.out.print(1);
            return 0;
        }
    }
}