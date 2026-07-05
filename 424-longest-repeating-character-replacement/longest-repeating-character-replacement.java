class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int count[] = new int[26];

        int maxLen = Integer.MIN_VALUE;

        for(int high = 0; high < n; high++){
            char right = s.charAt(high);

            count[right - 'A']++;
            int len = high - low + 1;
            int maxFreq = findFreq(count);
            int diff = len - maxFreq;

            while(diff > k){
                char leftChar = s.charAt(low);
                count[leftChar - 'A']--;
                low++;
                maxFreq = findFreq(count);
                len = high - low + 1;
                diff = len - maxFreq;
            }

            maxLen = Math.max(maxLen, high - low + 1);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    
    public int findFreq(int[] count){
        int freq = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++){
            freq = Math.max(freq, count[i]);
        }

        return freq == Integer.MIN_VALUE ? 0 : freq;
    }
}