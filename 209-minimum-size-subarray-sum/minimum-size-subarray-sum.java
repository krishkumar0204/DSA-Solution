class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int minLen = Integer.MAX_VALUE;
        int low = 0;
        int sum = 0;

        for(int high = 0; high < n; high++){
            sum += nums[high];

            while(sum >= target){
                minLen = Math.min(minLen, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}