class Solution {
    public void sortColors(int[] nums) {
        // Storing length of nums array into variable n
        int n = nums.length;

        // Initialize low = 0, mid = 0, high = n - 1
        int low = 0, mid = 0, high = n - 1;


        // loop runs until mid <= high
        while(mid <= high){
            // if mid pe value 0 hai to swap kar do low se taki starting me 0 place ho jaye
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){// mid pe value 1 hai to sirf mid ko next place pe inc kr do kyki mid me 1 hi arrange karna hai
                mid++;
            }else{
                // mid pe 2 val hai to usko high ke sath swap kar do taki last me place ho jaye
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}