class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int val = asteroids[i];
            if(val>0){
                st.push(val);
            }
            else{
                boolean pushNeg = true;

                while(st.size()>0 && st.peek()>0){
                    if(st.peek()>-(val)){
                        pushNeg = false;
                        break;
                    }
                    else if(st.peek()==-(val)){
                        st.pop();
                        pushNeg = false;
                        break;
                    }
                    else{
                        st.pop();
                    }
                }
                if(pushNeg) st.push(val);
            }
        }
        int[] ans = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
