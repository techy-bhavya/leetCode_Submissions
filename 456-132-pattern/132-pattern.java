class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        int[] minSoFar = new int[n];
        int min = nums[0];

        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
            minSoFar[i] = min;
        }
        Stack<Integer> possibleKValues = new Stack<>();
        possibleKValues.push(nums[n-1]);

        for(int j=n-2; j>=0; j--){
            min = minSoFar[j];
            // removing lesser than equal to minimum values
            while(possibleKValues.size() > 0 && min >= possibleKValues.peek()){
                possibleKValues.pop();
            }

            if(possibleKValues.size() > 0 && nums[j] > possibleKValues.peek()){
                return true;
            }

            possibleKValues.push(nums[j]);
        }

        return false;
    }
}