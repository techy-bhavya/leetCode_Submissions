class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b)-> {
            if(a[0] == b[0]){
                return b[1] - a[1]; // if 0th index equal, greater first idx will come before
            }
            return a[0] - b[0]; // increasing order sort
            // return b[0] - a[0]; -> decreasing order sort
        });
       List<int[]> ans = new ArrayList<>();
// First interval 
ans.add(intervals[0]);
for (int i = 1; i < intervals.length; i++) {
    int[] prev = ans.get(ans.size() - 1);
    int[] curr = intervals[i];

    if (curr[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], curr[1]);
    } else {
        ans.add(curr);
    }
}
return ans.toArray(new int[ans.size()][]);
    }
}