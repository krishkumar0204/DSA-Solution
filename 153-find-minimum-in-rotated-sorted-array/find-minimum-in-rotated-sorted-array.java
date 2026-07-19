class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0, high = n -1;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int guess = low + (high - low) /2;

            if(nums[low] <= nums[guess]){
                min = Math.min(min, nums[low]);

                low = guess + 1;
            }else{
                min = Math.min(min, nums[guess]);

                high = guess - 1;
            }
        }
        
        return min;
    }
}