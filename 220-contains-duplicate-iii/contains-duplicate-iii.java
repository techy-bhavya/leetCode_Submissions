import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(
        int[] nums,
        int indexDiff,
        int valueDiff
    ) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Remove elements that are too far away
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }

            // Find smallest number >= nums[i] - valueDiff
            Long x = set.ceiling((long) nums[i] - valueDiff);

            // Check whether x <= nums[i] + valueDiff
            if (x != null && x <= (long) nums[i] + valueDiff) {
                return true;
            }

            set.add((long) nums[i]);
        }

        return false;
    }
}