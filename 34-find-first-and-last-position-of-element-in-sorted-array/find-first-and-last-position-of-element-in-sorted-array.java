class Solution {
    public int getFirstIndex(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                ans = mid;
                right = mid-1;
            }
            else if(arr[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }

    public int getLastIndex(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                ans = mid;
                left = mid+1;
            }
            else if(arr[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        
        int leftIndex = getFirstIndex(nums, target);
        int rightIndex = getLastIndex(nums, target);
        return new int[]{leftIndex, rightIndex};

    }
}