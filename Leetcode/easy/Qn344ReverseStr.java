package easy;

public class Qn344ReverseStr {
	// Time 100%, Space 26.63%
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length-1; i < j; i++, j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

}
