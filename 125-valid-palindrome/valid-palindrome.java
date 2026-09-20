class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int size = cleaned.length();
        int i = 0;
        int j = size - 1;
        while(i<j){
            if(cleaned.charAt(i)!=cleaned.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
