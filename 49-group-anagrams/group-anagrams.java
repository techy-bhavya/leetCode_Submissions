class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            int[] count = new int[26];
            char[] array = s.toCharArray();
            for(char ch:array){
                count[ch-'a']++;
            }
            String sorted = Arrays.toString(count);
            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}