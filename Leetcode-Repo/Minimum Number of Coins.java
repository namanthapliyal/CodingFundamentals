import java.util.*;
import java.io.*;

public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int[][] dp = new int[num.length][x + 1];
        for (int i = 1; i < x + 1; i++) {
            if (i % num[0] == 0) {
                dp[0][i] = i / num[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < x + 1; j++) {
                int nottake = dp[i - 1][j];
                int take = Integer.MAX_VALUE;
                if (num[i] <= j && dp[i][j - num[i]] != Integer.MAX_VALUE) {
                    take = 1 + dp[i][j - num[i]];
                }
                dp[i][j] = Math.min(take, nottake);
            }
        }
        return dp[num.length - 1][x] == Integer.MAX_VALUE ? -1 : dp[num.length - 1][x];
    }
}

public class Solution2 {
    static final int MOD = (int) 1e9 + 7; // Define a modulo constant

    public static int f(int i, int x, int num[]) {
        if (i == 0) {
            if (x % num[i] == 0) {
                return x / num[i];
            } else {
                return Integer.MAX_VALUE; // Return a large value instead of MAX_VALUE
            }
        }
        int notake = f(i - 1, x, num);
        int take = MOD; // Initialize to MOD instead of MAX_VALUE
        if (num[i] <= x) {
            take = 1 + f(i, x - num[i], num);
        }
        return Math.min(take, notake);
    }

    public static int minimumElements(int num[], int x) {
        int ans = f(num.length - 1, x, num);
        return ans >= MOD ? -1 : ans; // Check against MOD instead of MAX_VALUE
    }
}