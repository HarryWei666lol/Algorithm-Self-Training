package easy;

public class Qn953VerifyAlienDict {
	// Time 100%, Space 100%
	public boolean isAlienSorted(String[] words, String order){
        if (words.length <= 1){
            return true;
        }
        for (int i = 1; i < words.length; i++){
            String cur = words[i];
            String prev = words[i-1];
            
            if (cur.length() >= prev.length() && cur.substring(0,prev.length()).equals(prev)){
                    continue;
                }

            if (cur.length() < prev.length() && prev.substring(0,cur.length()).equals(cur)){ // handle example 3
                return false;
            }

            for (int j = 0; j < cur.length() && j < prev.length(); j++){
                if (cur.charAt(j) == prev.charAt(j)){
                    continue;
                }
                else if (order.indexOf(prev.charAt(j)) < order.indexOf(cur.charAt(j))){
                   break; 
                } 
                else{
                    return false; 
                }
            }
            
        }
        return true;
    }

}
