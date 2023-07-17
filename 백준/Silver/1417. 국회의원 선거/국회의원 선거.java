import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public int solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 입력부
        int candidates = Integer.parseInt(reader.readLine());
        // 내 득표 수
        int myVote = Integer.parseInt(reader.readLine());
        // 제일 많은 득표자의 표를 먼저 뺏어야 하니까 Max 힙 사용
        PriorityQueue<Integer> otherVotes = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> otherVotes = new PriorityQueue<>((th, ot) -> ot - th);
        for(int i = 0; i < candidates - 1; i++){
            otherVotes.offer(Integer.parseInt(reader.readLine()));

        }

        // 알고리즘
        int answer = 0;

        // 단일 후보가 아닐 경우에만 계산 진행
        if(!otherVotes.isEmpty()){
            // 최다 득표자가 내 표보다 클 때 진행
            while(otherVotes.peek() >= myVote){
                // 최다 득표자의 표 수를 빼냄
                int votes = otherVotes.poll();
                // 최다 득표자의 득표 수를 1 줄이고 넣음
                otherVotes.offer(votes - 1);
                // 뺏은 표는 내것으로
                myVote++;
                // 매수 한 수
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}