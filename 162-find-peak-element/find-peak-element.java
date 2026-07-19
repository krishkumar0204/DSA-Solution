class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int low = 0, high = n-1;
        int res = -1;
       
        while(low <= high){
            int guess = low + (high - low)/2;

            if(guess == n-1 || nums[guess] > nums[guess+1]){
                res = guess;
                high = guess - 1;
            }else{
                low = guess + 1;
            }
        }
        return res;
    }
}