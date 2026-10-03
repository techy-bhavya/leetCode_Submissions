class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int ele: nums){
            minPQ.add(ele);
            if(minPQ.size()>k){
                minPQ.remove();
            }
        }
        return minPQ.peek();
    }
}