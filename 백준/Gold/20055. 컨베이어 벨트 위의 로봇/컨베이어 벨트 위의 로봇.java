import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int K;
    static Info[] belt;

    static int deactive;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new Info[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++) belt[i] = new Info(Integer.parseInt(st.nextToken()));

        int level = 0;

        while(deactive < K){
            level++;

            moveBelt();
            moveRobot();
            setNewRobot();

        }

        System.out.println(level);
    }

    static void moveBelt(){
        Info first = new Info(belt[0].durability);
        first.robot = belt[0].robot;

        for(int i = 2 * N - 1; i >= 0; i--){
            belt[(i + 1) % (2 * N)] = belt[i];
        }

        belt[1] = first;

        belt[N - 1].robot = false;
    }

    static void moveRobot(){
        for(int i = N - 2; i >= 0; i--){
            if(!belt[i + 1].robot && belt[i].robot && belt[i + 1].durability > 0){
                belt[i + 1].robot = true;
                belt[i + 1].durability -= 1;
                belt[i].robot = false;

                if(belt[i + 1].durability == 0) deactive++;
            }
        }

        belt[N - 1].robot = false;
    }

    static void setNewRobot(){
        if(!belt[0].robot && belt[0].durability > 0){
            belt[0].robot = true;
            belt[0].durability -= 1;

            if(belt[0].durability == 0) deactive++;
        }
    }

    static class Info{
        int durability;
        boolean robot;

        public Info(int durability){
            this.durability = durability;
        }
    }
}