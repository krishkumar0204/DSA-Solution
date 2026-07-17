class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int count = 0;
        
        for(int val : arr){
            if(val == target){
                count++;
            }
        }
        
        return count;
    }
}
