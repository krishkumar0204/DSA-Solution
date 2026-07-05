class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Sorting Array for finding correct Quadruplets
        Arrays.sort(nums);

        // Storing length of nums arr in variable n
        int n = nums.length;

        // for storing ans
        List<List<Integer>> res = new ArrayList<>();

        if(n == 0){
            return res;
        }

        // iterating on arr for fixed one pointer
        for(int i = 0; i < n - 3; i++){
            // inital check for quplicates
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            // fixed 2nd pointer
            for(int j = i + 1; j < n - 2; j++){
                // check for duplicates
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j + 1, l = n - 1;

                while(k < l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target){
                       List<Integer> Quadruplets = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);

                       res.add(Quadruplets);
                        
                        //check right duplicates
                        while(k < l && nums[k] == nums[k+1]){
                            k++;
                        }

                        // check left duplicates
                        while(k < l && nums[l] == nums[l-1]){
                            l--;
                        }

                        k++;
                        l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }



        return res;
    }
}