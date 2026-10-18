class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        table = new long[n + 1][n + 1];
        
        // Precompute Combinations (Pascal's Triangle)
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((getWays(list) - 1 + MOD) % MOD);
    }

    private long getWays(List<Integer> list) {
        if (list.size() <= 2) {
            return 1;
        }

        long root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < root) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        long leftWays = getWays(left);
        long rightWays = getWays(right);

        int leftSize = left.size();
        int totalSize = left.size() + right.size();

        long comb = table[totalSize][leftSize];

        return (((comb * leftWays) % MOD) * rightWays) % MOD;
    }
}
