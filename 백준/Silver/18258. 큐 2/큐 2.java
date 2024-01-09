import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Queue queue = new Queue();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push": queue.push(Integer.parseInt(st.nextToken())); break;
                case "pop": bw.append(queue.pop() + "\n"); break;
                case "size": bw.append(queue.size() + "\n"); break;
                case "empty": bw.append(queue.empty() + "\n"); break;
                case "front": bw.append(queue.front() + "\n"); break;
                case "back": bw.append(queue.back() + "\n"); break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Queue{
        Node first;
        Node last;
        int size = 0;

        static class Node{
            int value;
            Node next;

            public Node(int value){
                this.value = value;
            }
        }

        void push(int x){
            if(empty() == 1) {
                first = new Node(x);
                last = first;
            }
            else{
                last.next = new Node(x);
                last = last.next;
            }
            size++;
        }

        int pop(){
            if(empty() == 1) return -1;
            else{
                int remove = first.value;
                if(first == last){
                    first = null;
                    last = null;
                }
                else{
                    first = first.next;
                }
                size--;
                return remove;
            }
        }

        int size(){
            return size;
        }

        int empty(){
            if(first == null) return 1;
            else return 0;
        }

        int front(){
            if(empty() == 1) return -1;
            else return first.value;
        }

        int back(){
            if(empty() == 1) return -1;
            else{
                return last.value;
            }
        }
    }
}