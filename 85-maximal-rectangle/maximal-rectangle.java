class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    heights[j]+=1;
                }
                else{
                    heights[j]=0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

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