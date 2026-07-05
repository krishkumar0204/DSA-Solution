class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        
        int maxsum = sum;
        int low = 0;
        for(int i = k; i < n ; i++){
            sum += arr[i];
            sum -= arr[low];
            low++;
            maxsum = Math.max(maxsum, sum);
        }
        
        return maxsum;
    }
}