class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        // Store len of nums array in variable
        int n = nums.length;

        if(k <= 1){
            return 0;
        }

        int low = 0;
        int product = 1;
        int count = 0;

        for(int high = 0; high < n; high++){
            product *= nums[high];

            while(product >= k){
                product /= nums[low];
                low++;
            }

            count += (high - low + 1); 

        }

        return count;
    }
}