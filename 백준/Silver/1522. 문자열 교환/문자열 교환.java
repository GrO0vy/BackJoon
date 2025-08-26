import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        int window = 0;

        // 전체 a 개수 계산
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a') window++;
        }

        // edge case: a가 하나도 없거나 모두 a이면 0번 교환
        if (window == 0 || window == n) {
            System.out.println(0);
            return;
        }

        // 원형 처리 위해 2배
        str += str;

        int cntB = 0;

        // 초기 윈도우 설정 (0 ~ window-1)
        for (int i = 0; i < window; i++) {
            if (str.charAt(i) == 'b') cntB++;
        }

        int result = cntB;

        // 슬라이딩 윈도우 시작점 i = 1부터 시작
        for (int i = 1; i < n; i++) {
            // 왼쪽 문자 제거
            if (str.charAt(i - 1) == 'b') cntB--;
            // 오른쪽 문자 추가
            if (str.charAt(i + window - 1) == 'b') cntB++;

            result = Math.min(result, cntB);
        }

        System.out.println(result);
    }
}
