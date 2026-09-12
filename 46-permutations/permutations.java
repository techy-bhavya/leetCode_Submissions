class Solution {
    public void recPermute(int idx, int[] nums, List<List<Integer>> finalAns){
        if(idx==nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int i: nums){
                ans.add(i);
            }
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        for(int i = idx; i<nums.length;i++){
            swap(i, idx, nums);
            recPermute(idx+1, nums, finalAns);
            swap(i, idx, nums);
        }
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        recPermute(0, nums, finalAns);
        return finalAns;
    }
}