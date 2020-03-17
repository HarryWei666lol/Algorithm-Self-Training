package easy;

public class Qn1165SingleRowKeyboard {
	// time 78.13%, space 100%
	public int calculateTime(String keyboard, String word) {
        int time = 0;
        int[] count = new int[26];
        int prevLoc = 0;
        
        for(int i = 0; i < keyboard.length(); i++){
        	int charVal = keyboard.charAt(i) - 'a';
            count[charVal] = i;
        }
        
        for(int i = 0; i < word.length(); i++){
            int currLoc = count[word.charAt(i) - 'a'];
            time += Math.abs(currLoc - prevLoc);
            prevLoc = currLoc;
        }
        return time;
    }

}
