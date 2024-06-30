class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int ans = 0;
        int nzero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nzero++;
            }
            while (nzero > 1) {
                if (nums[left] == 0) {
                    nzero--;
                }
                left++;
            }
            ans = Math.max(i - left + 1, ans);
        }
        return ans;
    }
}