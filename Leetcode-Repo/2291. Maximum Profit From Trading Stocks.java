class Solution1 {
    // Will throw TLE error TC - O(2^N), SC-
    static int knapsack(int[] present, int[] future, int budget, int i) {
        if (i <= -1 || budget < 0) {
            return 0;
        }
        int buy = Integer.MIN_VALUE;
        int notbuy = Solution1.knapsack(present, future, budget, i - 1);
        if (future[i] > present[i] && budget >= present[i]) {
            buy = (future[i] - present[i]) + Solution1.knapsack(present, future, budget - present[i], i - 1);
        }
        return Math.max(buy, notbuy);
    }

    public int maximumProfit(int[] present, int[] future, int budget) {
        return Solution1.knapsack(present, future, budget, future.length - 1);
    }

    // Use dp with tabulation
}

class Sol2 {
    // Still throws TLE but TC - O(N^2)
    public int maximumProfit(int[] present, int[] future, int budget) {
        int[][] dp = new int[present.length][budget + 1];
        for (int i = present[0]; i < budget + 1; i++) {
            if (i <= budget && (future[0] - present[0]) > 0) {
                dp[0][i] = Math.max(0, future[0] - present[0]);
            }
        }
        int notbuy = 0;
        for (int i = 1; i < present.length; i++) {
            for (int j = 0; j < budget + 1; j++) {
                notbuy = dp[i - 1][j];
                int buy = 0;
                if (present[i] <= j && (future[i] - present[i]) > 0) {
                    buy = future[i] - present[i] + dp[i - 1][j - present[i]];
                }

                dp[i][j] = Math.max(buy, notbuy);
            }
        }
        return dp[present.length - 1][budget];
    }

}