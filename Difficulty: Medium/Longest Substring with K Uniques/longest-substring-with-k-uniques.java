class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        
        int maxLen = Integer.MIN_VALUE;
        int low = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int high = 0; high < n; high++){
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high) , 0) + 1);
            
            while(map.size() > k){
                map.put(s.charAt(low), map.get(s.charAt(low)) - 1);
                
                if(map.get(s.charAt(low)) == 0){
                    map.remove(s.charAt(low));
                }
                low++;
            }
            
            if(map.size() == k){
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }
        
        
        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }
}