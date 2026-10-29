class Solution {
    public int singleNumber(int[] nums) {
        int val = nums[0];
        for(int i=1;i<nums.length;i++){
            val = val ^ nums[i];
        }
        return val;
    }
}