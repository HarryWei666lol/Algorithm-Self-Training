package easy;

public class Qn13RomanToInt {
	// Time 100%, Space 100%
	public int romanToInt(String s) {
        int value = 0, current = 0, prev = 0;
        for(int i = 0; i < s.length(); i++){
            current = convertCharToInt(s.charAt(i));
            if(prev < current){
                value -= prev;
                value += current - prev;
            }
            else{
                value += current;
            }
            prev = current;
        }
        return value;
    }
    
    int convertCharToInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        throw new IllegalArgumentException("bla");
    }
}
