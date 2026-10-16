class Solution {
    public boolean checkValidString(String s) {
        int leftOpenCount_min = 0;
        int leftOpenCount_max = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                leftOpenCount_min += 1;
                leftOpenCount_max += 1;
            }
            else if(c==')'){
                leftOpenCount_min -= 1;
                leftOpenCount_max -= 1;
            }
            else{
                leftOpenCount_min -= 1;
                leftOpenCount_max += 1;
            }
            // somewhere within the string we got more closed brackets than opened ones, and thus string can never be valid
            if(leftOpenCount_max<0) return false; 
            // some asterisk will become open bracket to compensate
            if(leftOpenCount_min<0) leftOpenCount_min = 0;
        }
        return leftOpenCount_min == 0;
    }
}
