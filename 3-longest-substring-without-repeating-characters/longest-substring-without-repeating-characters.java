class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int maxLen = Integer.MIN_VALUE;
        int low = 0;
        Set<Character> set = new HashSet<>();

        for(int high = 0; high < len; high++){
            while(set.contains(s.charAt(high))){
                set.remove(s.charAt(low));
                low++;
            }
            set.add(s.charAt(high));
            maxLen = Math.max(maxLen, high - low + 1);

        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}