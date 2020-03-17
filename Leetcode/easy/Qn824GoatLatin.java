package easy;
import java.util.*;

public class Qn824GoatLatin {
	// time 95.18%, space 100%
	public String toGoatLatin(String S) {
        StringBuilder result = new StringBuilder();
        StringBuilder lastAppendStr = new StringBuilder();
        String[] words = S.split(" ");
        Set<Character> lowerVowels = new HashSet<>();
        lowerVowels.add('a');
        lowerVowels.add('e');
        lowerVowels.add('i');
        lowerVowels.add('o');
        lowerVowels.add('u');

        for (String word : words) {
            char firstChar = word.charAt(0);
            if (lowerVowels.contains(Character.toLowerCase(firstChar))) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(firstChar);
            }
            result.append("ma").append(lastAppendStr).append("a ");
            lastAppendStr.append("a");
        }
        
        return result.toString().trim(); // trim() removes the 'space' at the end of the output to make output correct
        
        //S: "I speak Goat Latin"
        //result: Imaa peaksmaaa oatGmaaaa atinLmaaaaa
        //lastAppendStr: aaa
        //words: ["I","speak","Goat","Latin"]
        //lowerVowels: [a, e, u, i, o]
        //word: "Latin"
        //firstChar: L
    }

}
