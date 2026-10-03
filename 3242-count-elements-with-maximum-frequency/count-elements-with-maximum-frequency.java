class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int num: nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }
        int c = 0;
        for(int num: nums){
            if(map.get(num) == maxFreq) c++;
        }
        return c;
    }
}