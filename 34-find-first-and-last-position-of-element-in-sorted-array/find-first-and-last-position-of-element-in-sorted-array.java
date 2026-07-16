class Solution {

    public int findFirst(int nums[], int target){
        int n = nums.length;

        int low = 0, high = n - 1;
        int res = -1;
        
        while(low <= high){
            int guess = low + (high - low)/2;

            if(nums[guess] < target){
                low = guess + 1;
            }else if(nums[guess] > target){
                high = guess - 1;
            }else{
                res = guess;
                high = guess - 1;
            }
        }
        
        return res;
    }

    public int findLast(int nums[], int target){
        int n = nums.length;

        int low = 0, high = n - 1;
        int res = -1;
        
        while(low <= high){
            int guess = low + (high - low) /2;

            if(nums[guess] < target){
                low = guess + 1;
            }else if(nums[guess] > target){
                high = guess - 1;
            }else{
                res = guess;
                low = guess + 1;
            }
        }


        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1, -1};
        int left = findFirst(nums, target);
        int right = findLast(nums, target);
        res[0] = left;
        res[1] = right;
        return res;
    }

    
}