package easy;

public class Qn387FirstUniqueCharInString {
    // time 95.96%, space 5.71%
    // Time O(n)
    public int firstUniqChar(String s) {
        if(s == null || s.length() <= 0){
            return -1;
        }
        int[] char_counts = new int[26];
        for(char c : s.toCharArray()){ // self-building a HashMap-like structure
            char_counts[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(char_counts[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

}
