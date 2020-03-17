package easy;

public class Qn1119RemoveVowelsFromStr {
	// time 100%, space 100%
    public String removeVowels(String S) {
        StringBuffer res = new StringBuffer();
        for(int i = 0; i<S.length(); i++){
            char character = S.charAt(i);
            if(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'){
                continue;
            }
            else{
                res.append(character);
            }
        }
        return res.toString();
    }

}
