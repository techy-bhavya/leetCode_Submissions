class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;   
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (st.size()>0 && currentHeight < heights[st.peek()]) {
                int ht = heights[st.pop()];
                int width = st.size()==0 ? i : i - st.peek() - 1;
                int area = ht*width;
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        return maxArea;
    }
}
