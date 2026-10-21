class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x>=0 && x<9) return true;
        int rev = 0;
        int temp = x;
        while(temp>0){
            rev = rev*10 + temp%10;
            temp/=10;
        }
        if(x==rev) return true;
        else return false;
    }
}