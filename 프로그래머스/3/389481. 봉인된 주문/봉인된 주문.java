import java.util.*;

class Solution {

    // 문자열을 숫자로 바꾸는 함수 (26진수 느낌)
    // 예: "a" -> 1, "z" -> 26, "aa" -> 27 이런 식으로 변환
    private long spellToOrder(String s) {
        long order = 0;      // 결과 숫자
        long base = 1;       // 26의 거듭제곱 역할 (자리수 계산용)

        // 뒤에서부터 한 글자씩 계산 (오른쪽부터 왼쪽으로)
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a' + 1; // 'a'는 1, 'b'는 2, ..., 'z'는 26
            order += c * base;              // 해당 자리수 숫자에 더함
            base *= 26;                    // 자리수 올리기 (26진법)
        }

        return order;
    }

    // 숫자를 다시 문자열로 바꾸는 함수 (위의 반대 작업)
    private String orderToSpell(long order) {
        StringBuilder sb = new StringBuilder();

        // 숫자가 0보다 클 동안 반복
        while (order > 0) {
            long rem = order % 26; // 26으로 나눈 나머지 구하기

            if (rem == 0) {
                // 나머지가 0이면 'z'로 치환하고 숫자를 1 줄임
                sb.append('z');
                order = (order / 26) - 1;
            } else {
                // 나머지가 1~25면 그에 해당하는 문자 추가
                sb.append((char) ('a' + rem - 1));
                order /= 26;
            }
        }

        // 지금까지 문자를 뒤에서부터 붙였으므로 뒤집어서 반환
        return sb.reverse().toString();
    }

    // 메인 함수: n번째 허용된 문자열 찾기
    public String solution(long n, String[] bans) {
        // bans를 숫자로 변환해서 배열에 저장
        long[] bansOrder = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            bansOrder[i] = spellToOrder(bans[i]);
        }

        // 금지된 문자열 숫자들 오름차순 정렬
        Arrays.sort(bansOrder);

        // 금지된 문자열 중 n 이하인 개수만큼 n을 증가시켜서 건너뛰기
        for (long banNum : bansOrder) {
            if (banNum <= n) {
                n++;  // 금지어 건너뛰기 위해 n 증가
            } else {
                break; // 이후 숫자는 모두 n보다 크므로 멈춤
            }
        }

        // 보정된 n을 숫자->문자열로 변환해서 결과 반환
        return orderToSpell(n);
    }
}
