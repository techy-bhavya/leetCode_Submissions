class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[st.peek()]>=heights[i]){
                int poppedIdx = st.pop();
                int ht = heights[poppedIdx];
                int nsr = i;
                int nsl = st.peek();
                int width = nsr - nsl - 1;
                int area = ht*width;
                maxArea  = Math.max(maxArea, area); 
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int poppedIdx = st.pop();
                int ht = heights[poppedIdx];
                int nsr = n;
                int nsl = st.peek();
                int width = nsr - nsl - 1;
                int area = ht*width;
                maxArea  = Math.max(maxArea, area); 
        }
        return maxArea;
    }
}