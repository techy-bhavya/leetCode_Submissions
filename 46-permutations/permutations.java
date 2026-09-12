class Solution {
    public void recPermute(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>> finalAns){
        for(int i=0;i<nums.length;i++){
            if(nums.length == ds.size()){
                finalAns.add(new ArrayList<>(ds));
                return;
            }

            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recPermute(nums, ds, freq, finalAns);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recPermute(nums, ds, freq, finalAns);
        return finalAns;
    }
}