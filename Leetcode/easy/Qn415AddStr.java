package easy;

public class Qn415AddStr {
	// Time 96.19%, Space 100%
    public String addStrings(String num1, String num2) {
        int i = num1.length() -1, j = num2.length() -1, carry = 0;
        StringBuffer result = new StringBuffer();
        while (i >= 0 || j >= 0){
            int sum = carry;
            if (i >= 0) {
            	sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
            	sum += num2.charAt(j--) - '0';
            }
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }
    // All we need to do is simply maintain two pointers i,j that traverse 
    // both strings from the right. If any pointer is <0, we know that's not a valid index 
    // and hence we are done traversing the string that the pointer refers to. We are done with both when i<0 and j<0.

    // We also need to keep a track of the carry, which we add as needed to every iteration. 
    // At the end of the traversals, we reverse the string buffer and return. 
    // Watch out for the case where carry > 0 at the end of the traversals!

}
