class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        int k = 2;
        
        int low = 0;
        for(int high = 0; high < n; high++){
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);

            while(map.size() > k){
                map.put(fruits[low], map.get(fruits[low]) - 1);

                if(map.get(fruits[low]) == 0){
                    map.remove(fruits[low]);
                }

                low++;
            }

            if(map.size() == k || map.size() < k){
                maxCount = Math.max(maxCount, high - low + 1);
            }

        }

        return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
    }
}