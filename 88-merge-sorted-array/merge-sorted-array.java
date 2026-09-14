class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int i = 0; //to traverse on nums1
        int j=0; //to traverse on nums2
        int k=0; //to traverse on res

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[k] = nums1[i];
                i++;
            }
            else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<m){
            res[k++] = nums1[i++];
        }

        while(j<n){
            res[k++] = nums2[j++];
        }

        for(int ass = 0; ass<nums1.length;ass++){
            nums1[ass] = res[ass];
        }
    }
}