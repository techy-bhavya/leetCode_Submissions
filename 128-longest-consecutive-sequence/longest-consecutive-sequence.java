class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums){
            set.add(ele);
        }
        int maxSize = 0;
        for(int ele:nums){
            int currSize = 1;
            int left = ele-1;
            int right = ele+1;
            while(set.contains(left)){
                set.remove(left);
                currSize++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);
                currSize++;
                right++;
            }
            maxSize = Math.max(maxSize, currSize);
        }
        return maxSize;
    }
}