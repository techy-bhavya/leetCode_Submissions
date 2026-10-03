class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele:nums1){
            set.add(ele);//no need of frequency
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele: nums2){
            if(set.contains(ele)){
                ans.add(ele);
                set.remove(ele);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}