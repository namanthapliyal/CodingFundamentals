/**
 * Definition for a category handler.
 * class CategoryHandler {
 * public CategoryHandler(int[] categories);
 * public boolean haveSameCategory(int a, int b);
 * };
 */
class Solution {
    // Space: O(N), time: N(N+logN)
    public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean check;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                check = categoryHandler.haveSameCategory(i, j);
                if (check) {
                    parent[i] = j;
                    break;
                }
            }
        }
        Arrays.sort(parent);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (parent[i] != parent[i - 1]) {
                ans += 1;
            }
        }
        return ans;
    }
}