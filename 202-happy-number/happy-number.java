class Solution {
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        
        int slow = n;
        int fast = n;

        do{
            slow = getNext(slow);
            fast = getNext(getNext(fast));

        }while(slow != fast);

        return slow == 1;
    }

    public int getNext(int n){
        int res = 0;

        while(n > 0){
            int rem = n  % 10;
            res += Math.pow(rem,2);
            n /= 10;
        }

        return res;
    }
}