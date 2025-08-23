import java.math.BigInteger;
import java.util.*;

class Solution {

    // 문자열의 사전 순 인덱스 계산 (1-based)
    public static BigInteger getLexOrder(String s) {
        int base = 26; // 알파벳 수
        BigInteger total = BigInteger.ZERO;
        int length = s.length();

        // 길이 1부터 length-1까지의 문자열 개수 누적
        for (int len = 1; len < length; len++) {
            total = total.add(BigInteger.valueOf(base).pow(len));
        }

        // 현재 문자열이 length자리 문자열 중 어디에 있는지 계산
        for (int i = 0; i < length; i++) {
            int charIndex = s.charAt(i) - 'a'; // 현재 문자 인덱스 (0~25)
            BigInteger count = BigInteger.valueOf(charIndex)
                    .multiply(BigInteger.valueOf(base).pow(length - i - 1));
            total = total.add(count); // 자리수 기여도 누적
        }

        return total.add(BigInteger.ONE); // 1-based 인덱스로 변환
    }

    // 사전 순 인덱스로부터 문자열 복원
    public static String getStringFromOrder(BigInteger order) {
        BigInteger base = BigInteger.valueOf(26); // 알파벳 수
        order = order.subtract(BigInteger.ONE);   // 0-based로 변환

        int length = 1; // 문자열 길이 초기화
        BigInteger total = BigInteger.valueOf(26); // 누적 개수
        BigInteger count = BigInteger.valueOf(26); // 현재 길이 문자열 수

        // 해당 인덱스가 속한 문자열 길이 찾기
        while (order.compareTo(total) >= 0) {
            length++;
            count = count.multiply(base);
            total = total.add(count);
        }

        // 이전까지의 총 문자열 수 계산
        total = BigInteger.ZERO;
        count = BigInteger.ONE;
        for (int i = 1; i < length; i++) {
            count = count.multiply(base);
            total = total.add(count);
        }

        // 현재 길이 내 인덱스 구하기
        BigInteger indexInLength = order.subtract(total);

        // base-26 변환 (알파벳 조합)
        char[] result = new char[length];
        for (int i = length - 1; i >= 0; i--) {
            BigInteger[] divmod = indexInLength.divideAndRemainder(base);
            result[i] = (char) ('a' + divmod[1].intValue()); // 나머지로 문자 결정
            indexInLength = divmod[0]; // 몫으로 다음 자리수 계산
        }

        return new String(result);
    }

    // bannedSet을 TreeSet으로 두고, order 이하의 개수를 빠르게 계산
    private BigInteger countAcceptedUpTo(BigInteger order, NavigableSet<BigInteger> bannedSet) {
        int bannedCount = bannedSet.headSet(order, true).size(); // order 이하 금지어 개수
        return order.subtract(BigInteger.valueOf(bannedCount)); // 허용된 문자열 수
    }

    // 메인 함수: n번째 허용된 문자열 찾기
    public String solution(long n, String[] bans) {
        BigInteger targetIndex = BigInteger.valueOf(n); // 목표 인덱스

        // TreeSet 사용: 정렬된 금지어 인덱스 저장
        NavigableSet<BigInteger> bannedSet = new TreeSet<>();
        for (String ban : bans) {
            bannedSet.add(getLexOrder(ban));
        }

        // 이분 탐색 시작
        BigInteger low = BigInteger.ONE;                // 최소 사전 인덱스
        BigInteger high = BigInteger.ONE.shiftLeft(60); // 충분히 큰 값 (26^10 이상)

        // 이분 탐색으로 허용된 n번째 문자열 인덱스 찾기
        while (low.compareTo(high) < 0) {
            BigInteger mid = low.add(high).divide(BigInteger.TWO);
            BigInteger accepted = countAcceptedUpTo(mid, bannedSet);

            if (accepted.compareTo(targetIndex) < 0) {
                low = mid.add(BigInteger.ONE); // 더 큰 범위 탐색
            } else {
                high = mid; // mid가 가능성이 있음
            }
        }

        return getStringFromOrder(low); // 찾은 인덱스로 문자열 복원
    }
}
