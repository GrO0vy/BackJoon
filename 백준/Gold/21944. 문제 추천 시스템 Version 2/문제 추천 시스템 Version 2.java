import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, TreeSet<Problem>> subtrees;
    static Map<Integer, Problem> numberMap;
    static TreeSet<Problem> problems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        subtrees = new HashMap<>();
        numberMap = new HashMap<>();
        problems = new TreeSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int algorithm = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(number, level, algorithm);

            problems.add(problem);
            numberMap.put(number, problem);

            subtrees.putIfAbsent(algorithm, new TreeSet<>());
            subtrees.get(algorithm).add(problem);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int algorithm = Integer.parseInt(st.nextToken());
                int pos = Integer.parseInt(st.nextToken());
                sb.append(recommend(algorithm, pos)).append("\n");

            } else if (command.equals("recommend2")) {
                int pos = Integer.parseInt(st.nextToken());
                sb.append(recommend2(pos)).append("\n");

            } else if (command.equals("recommend3")) {
                int pos = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());
                sb.append(recommend3(pos, target)).append("\n");

            } else if (command.equals("add")) {
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                int algorithm = Integer.parseInt(st.nextToken());

                Problem problem = new Problem(number, level, algorithm);

                problems.add(problem);
                numberMap.put(number, problem);
                subtrees.putIfAbsent(algorithm, new TreeSet<>());
                subtrees.get(algorithm).add(problem);

            } else if (command.equals("solved")) {
                int number = Integer.parseInt(st.nextToken());
                Problem problem = numberMap.get(number);

                problems.remove(problem);
                subtrees.get(problem.algorithm).remove(problem);
                numberMap.remove(number);
            }
        }

        System.out.print(sb.toString());
    }

    static int recommend(int algorithm, int pos) {
        TreeSet<Problem> subtree = subtrees.get(algorithm);
        if (subtree == null || subtree.isEmpty()) return -1;

        return pos == 1 ? subtree.last().number : subtree.first().number;
    }

    static int recommend2(int pos) {
        if (problems.isEmpty()) return -1;

        return pos == 1 ? problems.last().number : problems.first().number;
    }

    static int recommend3(int pos, int targetLevel) {
        Problem target;

        if (pos == 1) {
            target = problems.ceiling(new Problem(-1, targetLevel, -1));
        } else {
            target = problems.floor(new Problem(Integer.MAX_VALUE, targetLevel - 1, -1));
        }

        return target != null ? target.number : -1;
    }

    static class Problem implements Comparable<Problem> {
        int number;
        int level;
        int algorithm;

        public Problem(int number, int level, int algorithm) {
            this.number = number;
            this.level = level;
            this.algorithm = algorithm;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level != o.level) return this.level - o.level;
            return this.number - o.number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Problem p = (Problem) o;
            return number == p.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }
}
