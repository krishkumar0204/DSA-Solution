class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorting Array
        Arrays.sort(nums);

        // Storing size of array in variable
        int n = nums.length;

        // for storing answer
        List<List<Integer>> res = new ArrayList<>();

        // Iterating from 0 to n - 2 because we need triplets 
        for(int i = 0; i < n - 2; i++){
            // checking for duplicates
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            // 2 Dynamic pointer and i is fixed pointer
            int j = i + 1, k = n - 1;

            // jab tak j < k rahega tab tak ye loop run karega
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // check for duplicates right
                    while(j < k && nums[j] == nums[j+1]){
                        j++; 
                    }

                    // check for duplicates left
                    while(j < k && nums[k] == nums[k-1]){
                        k--;
                    }

                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        

        return res;
    }
}