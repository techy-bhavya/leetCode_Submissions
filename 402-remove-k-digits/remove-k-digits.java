class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<num.length(); i++){
            int digit = num.charAt(i) - '0';

            while(k > 0 && st.size() > 0 && st.peek() > digit){
                st.pop();
                k--;
            }

            st.push(digit);
        }

        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(st.size() > 0){
            sb.append(st.pop());
        }
        int j = sb.length() - 1;
        while(j>=0 && sb.charAt(j) == '0'){
            sb.deleteCharAt(j);
            j--;
        }

        sb.reverse();

        return sb.length() == 0 ? "0" : sb.toString();
    }
}