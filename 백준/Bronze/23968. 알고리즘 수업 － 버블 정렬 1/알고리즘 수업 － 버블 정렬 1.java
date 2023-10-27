import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int[] a = new int[num1];

        // 숫자 입력 받기
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        // 임시 저장 공간
        int tmp = 0;

        // 버블정렬 알고리즘
        for(int i = a.length - 1; i>=0; i--) {
            for(int j = 0; j<i; j++) {
                if(a[j] >= a[j+1]) { // j번지와 j+1 번지의 값을 비교
                    --num2;
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    if(num2 == 0) {
                        System.out.printf("%d %d", a[j], a[j+1]);
                    }
                }
            }
        }
        if(num2 > 0) { // num2 > 0 이면 교환횟수가 num2 보다 적었다는 뜻
            System.out.println(-1);
        }
    }
}