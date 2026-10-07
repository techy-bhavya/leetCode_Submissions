class Solution {
    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        dfs(s, 0, left, right, 0, new StringBuilder());
        return new ArrayList<>(ans);
    }
    void dfs(String s, int index, int leftRemove, int rightRemove,
        int open, StringBuilder cur) {
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && open == 0) {
                ans.add(cur.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(' && leftRemove > 0) {
            dfs(s, index + 1, leftRemove - 1, rightRemove, open, cur);
        }
        if (c == ')' && rightRemove > 0) {
            dfs(s, index + 1, leftRemove, rightRemove - 1, open, cur);
        }
        if (c == '(') {
            cur.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, open + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        else if (c == ')') {
            if (open > 0) {
                cur.append(c);
                dfs(s, index + 1, leftRemove, rightRemove, open - 1, cur);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
        else {
            cur.append(c);
            dfs(s, index + 1, leftRemove, rightRemove, open, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}