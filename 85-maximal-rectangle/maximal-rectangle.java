class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
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
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            while(st.peek()!=-1 && heights[st.peek()] >= heights[i]){
                int poppedIdx = st.pop();

                int h = heights[poppedIdx];
                int nsr = i;
                int nsl = st.peek();

                maxArea = Math.max(maxArea, h*(nsr - nsl - 1));
            }

            st.push(i);
        }

        while(st.peek() != -1){
            int poppedIdx = st.pop();

            int h = heights[poppedIdx];
            int nsr = n;
            int nsl = st.peek();

            maxArea = Math.max(maxArea, h*(nsr - nsl - 1));
        }

        return maxArea;
    }
}