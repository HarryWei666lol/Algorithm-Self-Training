package medium;

public class Qn5LongestPalindromicSubstring {

	public int low, maxLen;
	
	// Time 53.27% Space 50.40%
	// Time O(n^2)
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        for (int i = 0; i < len-1; i++) { // at each index, try to extend out both sides
            
            //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i);
            
            //assume even length.
            extendPalindrome(s, i, i+1); 
        }
        return s.substring(low, low + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        
        if (maxLen < k - j - 1) {
            low = j + 1;
            maxLen = k - j - 1;
        }
    }

}
