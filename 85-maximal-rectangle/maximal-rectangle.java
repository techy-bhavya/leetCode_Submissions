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
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Arrays.fill(nse,n);
        Arrays.fill(pse,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()>0){
                nse[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()>0){
                pse[i] = st.peek();
            }
            st.push(i);
        }
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int ht = heights[i];
            int width = nse[i]-pse[i]-1;
            int area = ht*width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}