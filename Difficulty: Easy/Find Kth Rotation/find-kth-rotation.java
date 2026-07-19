class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        
        int res = 0;
        int low = 0, high = n -1;
        
        while(low <= high){
            int guess = low + (high - low)/2;
            
            if(arr[guess] > arr[n-1]){
                res += (guess - low  + 1);
                low = guess + 1;
            }else{
                high = guess - 1;
            }
        }
        
        return res;
        
    }
}