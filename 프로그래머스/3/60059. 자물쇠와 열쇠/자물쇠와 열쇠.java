import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        for (int dir = 0; dir < 4; dir++) {
            key = rotate(key);
            for (int dx = -key.length + 1; dx < lock.length; dx++) {
                for (int dy = -key.length + 1; dy < lock.length; dy++) {
                    if (isPossible(key, lock, dx, dy)) return true;
                }
            }
        }
        return false;
    }

    int[][] rotate(int[][] key) {
        int[][] rotatedKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                rotatedKey[j][key.length - i - 1] = key[i][j];
            }
        }
        return rotatedKey;
    }

    boolean isPossible(int[][] key, int[][] lock, int deltaX, int deltaY) {
        int N = lock.length;
        int M = key.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int keyX = i - deltaX;
                int keyY = j - deltaY;

                int keyVal = 0;
                if (inRange(keyX, keyY, M)) {
                    keyVal = key[keyX][keyY];
                }

                if (lock[i][j] + keyVal != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean inRange(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}