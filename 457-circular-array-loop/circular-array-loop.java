class Solution {
    public int calNext(int nums[], int curr){
        int n = nums.length;

        int next = (curr + nums[curr])  % n;

        if(next < 0){
            next += n;
        }

        return next;
    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            // 0 means this index is already visited and confirmed invalid

            if(nums[i] == 0){
                continue;
            }

            int slow = i;
            int fast = i;
            boolean isPos = nums[i] > 0;

            while(true){
                slow = calNext(nums, slow);

                // Validate slow pointer's sign
                if((nums[slow] > 0) != isPos){
                    break;
                }

                // Fast Pointer step 1
                fast = calNext(nums, fast);
                if((nums[fast] > 0) != isPos){
                    break;
                }

                // Fast pointer step 2
                fast = calNext(nums, fast);
                if((nums[fast]) > 0 != isPos){
                    break;
                }

                if(slow == fast){
                    // Check if the loop length is greater than 1
                    if(slow == calNext(nums, slow)){
                        break;
                    }
                    return true;
                }

            }

            // Optimization : Mark all elements in this field path as 0
            slow = i;
            while((nums[slow] > 0) == isPos && nums[slow] != 0){
                int next = calNext(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }

        return false;
    }
}