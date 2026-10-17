import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // 1. Create a copy and sort it based on the problem's criteria
        Integer[] sortedNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = nums[i];
        }
        
        Arrays.sort(sortedNums, (a, b) -> {
            int sumA = getDigitSum(a);
            int sumB = getDigitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        
        // 2. Map each element to its correct target index in the sorted array
        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndexMap.put(sortedNums[i], i);
        }
        
        // 3. Count swaps by traversing the cycles
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            // If already visited or in the correct spot, skip
            if (visited[i] || targetIndexMap.get(nums[i]) == i) {
                continue;
            }
            
            // Find the size of the cycle
            int cycleSize = 0;
            int curr = i;
            
            while (!visited[curr]) {
                visited[curr] = true;
                curr = targetIndexMap.get(nums[curr]);
                cycleSize++;
            }
            
            // Add swaps needed for this cycle
            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }
        
        return totalSwaps;
    }
    
    // Helper method to compute the sum of digits
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
