class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        Arrays.fill(nge, n);
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.size()>0){
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int[] ans = new int[n-k+1];
        int answerIdx = 0;

        for(int idx=0; idx<ans.length; idx++){ // idx = starting point of window
            if(answerIdx < idx){
                answerIdx = idx;
            }

            while(nge[answerIdx] < idx + k){
                answerIdx = nge[answerIdx];
            }

            ans[idx] = nums[answerIdx];
        }
        
        return ans;
    }
}