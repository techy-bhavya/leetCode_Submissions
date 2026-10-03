class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele:nums1){
            map.put(ele, 1);//no need of frequency
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele: nums2){
            if(map.containsKey(ele)){
                ans.add(ele);
                map.remove(ele);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}