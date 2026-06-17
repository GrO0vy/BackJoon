import java.util.*;

class Solution {

    int[] answer;
    boolean[] selected;
    int[][] diceInfo;

    int maxWin = -1;

    public int[] solution(int[][] dice) {

        diceInfo = dice;

        int n = dice.length;

        answer = new int[n / 2];
        selected = new boolean[n];

        selectDice(0, 0);

        return answer;
    }

    // 조합 선택
    private void selectDice(int start, int cnt) {

        if (cnt == answer.length) {

            int win = getWinCount();

            if (win > maxWin) {
                maxWin = win;
                saveAnswer();
            }

            return;
        }

        for (int i = start; i < diceInfo.length; i++) {

            selected[i] = true;

            selectDice(i + 1, cnt + 1);

            selected[i] = false;
        }
    }

    private int getWinCount() {

        List<Integer> diceA = new ArrayList<>();
        List<Integer> diceB = new ArrayList<>();

        for (int i = 0; i < selected.length; i++) {

            if (selected[i]) diceA.add(i);
            else diceB.add(i);
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();

        makeSum(diceA, 0, 0, sumA);
        makeSum(diceB, 0, 0, sumB);

        Collections.sort(sumB);

        int win = 0;

        for (int a : sumA) {

            int left = 0;
            int right = sumB.size();

            while (left < right) {

                int mid = (left + right) / 2;

                if (sumB.get(mid) < a) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            win += left;
        }

        return win;
    }

    // 특정 그룹의 합 생성
    private void makeSum(
        List<Integer> dices,
        int depth,
        int sum,
        List<Integer> result
    ) {

        if (depth == dices.size()) {
            result.add(sum);
            return;
        }

        int diceIdx = dices.get(depth);

        for (int i = 0; i < 6; i++) {

            makeSum(
                dices,
                depth + 1,
                sum + diceInfo[diceIdx][i],
                result
            );
        }
    }

    private void saveAnswer() {

        int idx = 0;

        for (int i = 0; i < selected.length; i++) {

            if (selected[i]) {
                answer[idx++] = i + 1;
            }
        }
    }
}