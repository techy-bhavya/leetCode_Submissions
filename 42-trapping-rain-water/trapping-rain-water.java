class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] lmax = new int[n];
        int[] rmax = new int[n];

        for(int i=1; i<n; i++){
            lmax[i] = Math.max(lmax[i-1], height[i-1]);
        }

        for(int i=n-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1], height[i+1]);
        }

        int totalWater = 0;
        
        for(int i=1; i<= n-2; i++){
            int maxWaterAllowed = Math.min(lmax[i], rmax[i]);

            int currentWaterUnits = Math.max(maxWaterAllowed - height[i], 0);

            totalWater += currentWaterUnits;
        }

        return totalWater;
    }
}