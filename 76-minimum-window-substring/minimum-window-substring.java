class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m == 0 || n == 0 || m < n){
            return "";
        }

        int tCount[] = new int[256];

        // Storing freq of char of String t
        for(int i = 0; i < n; i++){
            char ch = t.charAt(i);
            tCount[ch]++;
        }

        int sCount[] = new int[256];
        int low = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for(int high = 0; high < m; high++){
            char ch = s.charAt(high);
            sCount[ch]++;

            while(isMatch(tCount, sCount)){
                int len = high - low + 1;
                if(minLen > len){
                    minLen = len;
                    start = low;
                }
                sCount[s.charAt(low)]--;
                low++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public boolean isMatch(int tCount[], int sCount[]){
        for(int i = 0; i < 256; i++){
            if(sCount[i] < tCount[i]){
                return false;
            }
        }

        return true;
    }
}