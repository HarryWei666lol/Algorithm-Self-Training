package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Qn20ValidParentheses {

	// Time 98.61%, Space 5.06%
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.offerFirst(')');
            } else if ( c == '{'){
                stack.offerFirst('}');
            } else if ( c == '['){
                stack.offerFirst(']');
            }
            else if(stack.isEmpty() || stack.pollFirst() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
