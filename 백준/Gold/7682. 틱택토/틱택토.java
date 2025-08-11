import java.io.*;

public class Main{
    static final String EOF = "end";
    static final int SIZE = 3;
    static final String INVALID = "invalid\n";
    static final String VALID = "valid\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        while(!input.equals(EOF)){
            char[][] map = new char[SIZE][SIZE];

            int cntX = 0;
            int cntO = 0;
            int idx = 0;

            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    map[i][j] = input.charAt(idx++);

                    if(map[i][j] == 'X') cntX++;
                    if(map[i][j] == 'O') cntO++;
                }
            }

            String result = INVALID;

            if(cntX == cntO + 1){
                if(cntX + cntO == 9 && !bingo(map, 'O') || bingo(map, 'X') && !bingo(map, 'O')) result = VALID;
            }
            else if(cntX == cntO){
                if(bingo(map, 'O') && !bingo(map, 'X')) result = VALID;
            }

            sb.append(result);

            input = br.readLine();
        }

        System.out.println(sb.toString());
    }

    static boolean bingo(char[][] map, char c){
        // 가로, 세로
        for(int i = 0; i < SIZE; i++){
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) return true;
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;
        }

        // 대각선
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;

        if(map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;

        return false;
    }
}