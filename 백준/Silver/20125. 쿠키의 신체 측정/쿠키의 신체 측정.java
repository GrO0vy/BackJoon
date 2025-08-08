import java.io.*;

public class Main{
    static int N;
    static char[][] map;
    static int[] heart;
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        result = new int[5];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        heart = findHeart();

        findArms();
        findWaist();
        findLegs();

        System.out.printf("%d %d\n", heart[0] + 1, heart[1] + 1);
        System.out.printf("%d %d %d %d %d", result[0], result[1], result[2], result[3], result[4]);
    }

    static int[] findHeart(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == '*'){
                    return new int[]{i + 1, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    static void findArms(){
        int heartX = heart[0];
        int heartY = heart[1];

        int leftArm = 0;
        int rightArm = 0;

        for(int i = heartY - 1; i >= 0 && map[heartX][i] == '*'; i--) leftArm++;
        for(int i = heartY + 1; i < N && map[heartX][i] == '*'; i++) rightArm++;

        result[0] = leftArm;
        result[1] = rightArm;
    }

    static void findWaist(){
        int heartX = heart[0];
        int heartY = heart[1];

        int waist = 0;
        for(int i = heartX + 1; i < N && map[i][heartY] == '*'; i++) waist++;

        result[2] = waist;
    }

    static void findLegs(){
        int heartX = heart[0];
        int heartY = heart[1];

        int leftLeg = 0;
        int rightLeg = 0;

        for(int i = heartX + 1; i < N; i++){
            if(map[i][heartY - 1] == '*') leftLeg++;
            if(map[i][heartY + 1] == '*') rightLeg++;
        }

        result[3] = leftLeg;
        result[4] = rightLeg;
    }
}