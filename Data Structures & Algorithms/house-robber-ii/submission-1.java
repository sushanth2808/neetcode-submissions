class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
            robbery(nums, n-2, dp1, 0), // exclude last
            robbery(nums, n-1, dp2, 1)  // exclude first
        );
    }

    private int robbery(int[] nums, int i, int[] dp, int start){
        if(i < start) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = Math.max(
            robbery(nums, i-1, dp, start),            // skip
            nums[i] + robbery(nums, i-2, dp, start)   // take
        );

        return dp[i];
    }
}