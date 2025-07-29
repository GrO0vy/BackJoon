import java.util.*;
import java.io.*;

public class Main{
    static int p;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<List<User>> rooms = new ArrayList<>();

        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean isParticipate = false;

            for(List<User> room: rooms){
                if(!isFull(room) && inRange(room.get(0), level)){
                    room.add(new User(level, nickname));
                    isParticipate = true;
                    break;
                }
            }

            if(!isParticipate) {
                List<User> newRoom = new ArrayList<>();
                newRoom.add(new User(level, nickname));

                rooms.add(newRoom);
            }
        }

        for(List<User> room: rooms){
            if(room.size() == m) System.out.println("Started!");
            else System.out.println("Waiting!");

            Collections.sort(room, ((o1, o2) -> o1.nickname.compareTo(o2.nickname)));

            for(User user: room){
                System.out.printf("%d %s\n", user.level, user.nickname);
            }
        }
    }

    static boolean isFull(List<User> room) {
        return room.size() == m;
    }

    static boolean inRange(User captain, int level){
        return captain.level - 10 <= level && level <= captain.level + 10;
    }

    static class User{
        int level;
        String nickname;

        public User(int level, String nickname){
            this.level = level;
            this.nickname = nickname;
        }
    }
}