import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {

        int n = matrix_sizes.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int len = 1; len < n; len++) {

            for (int i = 0; i + len < n; i++) {

                int end = i + len;

                for (int k = i; k < end; k++) {

                    dp[i][end] = Math.min(
                        dp[i][end],
                        dp[i][k]
                        + dp[k + 1][end]
                        + matrix_sizes[i][0]
                        * matrix_sizes[k][1]
                        * matrix_sizes[end][1]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}