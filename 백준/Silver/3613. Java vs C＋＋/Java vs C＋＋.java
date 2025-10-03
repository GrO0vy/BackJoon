import java.io.*;

public class Main {
    static String var;
    static final String ERROR = "Error!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var = br.readLine();

        if (isError()) {
            var = ERROR;
        } else if (isCpp()) {
            var = cppToJava();
        } else {
            var = javaToCpp();
        }

        System.out.println(var);
    }

    static boolean isError() {
        if (var.length() == 0) return true;

        boolean containsUnderBar = var.contains("_");
        boolean containsUpperCase = false;

        for (int i = 0; i < var.length(); i++) {
            char ch = var.charAt(i);
            if (Character.isUpperCase(ch)) {
                containsUpperCase = true;
            }
        }

        // 첫 글자 or 마지막 글자가 언더바 → 에러
        if (var.charAt(0) == '_' || var.charAt(var.length() - 1) == '_') return true;

        // 첫 글자가 소문자가 아니면 에러
        if (!Character.isLowerCase(var.charAt(0))) return true;

        // 연속 언더바 → 에러
        if (var.contains("__")) return true;

        // 언더바 + 대문자 동시에 존재 → 에러
        if (containsUnderBar && containsUpperCase) return true;

        return false;
    }

    static boolean isCpp() {
        return var.contains("_");
    }

    static String javaToCpp() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < var.length(); i++) {
            char ch = var.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append("_").append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    static String cppToJava() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < var.length(); i++) {
            char ch = var.charAt(i);
            if (ch == '_') {
                // 인덱스 범위 초과 방지
                if (i + 1 >= var.length()) return ERROR;
                i++;
                sb.append(Character.toUpperCase(var.charAt(i)));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}