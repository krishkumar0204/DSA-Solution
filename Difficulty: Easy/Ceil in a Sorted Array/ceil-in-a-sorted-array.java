class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int n = arr.length;
        
        int low = 0, high = n - 1;
        
        int minEle = Integer.MAX_VALUE;
        
        while(low <= high){
            int guess = low + (high - low)/2;
            
            int ele = (int) Math.ceil(arr[guess]);
            
            if(x <= ele){
                minEle = Math.min(minEle, ele);
                high = guess - 1;
            }else{
                low = guess + 1;
            }
        }
        
        if(minEle != Integer.MAX_VALUE){
            for(int i = 0; i < n; i++){
                if(arr[i] == minEle){
                    return i;
                }
            }
        }
        
        return -1;
    }
}
