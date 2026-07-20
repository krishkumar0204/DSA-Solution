class Solution {
    public int search(int[] nums, int target) {
        int n  = nums.length;
        if(n == 0){
            return -1;
        }

        int low = 0, high = n-1;

        while(low <= high){
            int guess = low + (high - low)/2;

            if(nums[guess] == target){
                return guess;
            }

            // Part1
            if(nums[guess] > nums[n-1]){
                if(nums[guess] < target){
                    low = guess + 1;
                }else{
                    if(nums[0] > target){
                        low = guess + 1;
                    }else{
                        high = guess - 1;
                    }
                }
                
            }else{
                // Part2
                if(nums[guess] > target){
                    high = guess-1;
                }else{
                    if(nums[n-1] < target){
                        high = guess - 1;
                    }else{
                        low = guess + 1;
                    }
                }
            }
        }

    return -1;
    }
}