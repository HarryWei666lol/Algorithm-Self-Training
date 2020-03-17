package HeapAndGraphSearchII;
import java.util.*;

public class CombinationsOfCoins_M {


	public List<List<Integer>> combinations(int target, int[] coins) {
		// Each combination is represented as a List<Integer> curr
		// and curr.get(i) = the number of coins of coins[i]
		// all the combinations are stored in the res as List of List<Integer>
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();

		if(target == 0){
			return res;
		}

		helper(coins, target, 0, curr, res);

		return res;
	}

	private void helper(int[] coins, int moneyLeft, int index, List<Integer> curr, List<List<Integer>> res){
		// terminate condition:
		// Note: this can also be done at index == coins.length where all the coins have been picked
		// but a probably better one is at a previous level to reduce the number of unncessary branches
		// in the DFS
		// Think about it, coins.length - 1 represents the last coin we can use and actually what we can
		// do at this level is to get moneyLeft / coins[coins.length - 1] coins if possible
		if(index == coins.length - 1){
			if(moneyLeft % coins[index] == 0){ // coins.length - 1 = index
				curr.add(moneyLeft / coins[index]);
				res.add(new ArrayList<>(curr));
				curr.remove(curr.size() - 1); // remove the just-added element for future usage 
				// as this curr already exists in res
			}
			return;
		}

		// for coins[index], we can pick 0, 1, 2, .... , (moneyLeft/ coins[index]) coins
		int max = moneyLeft / coins[index];
		for(int i = 0; i <= max; i++){
			curr.add(i);
			helper(coins, moneyLeft - i * coins[index], index + 1, curr, res); // remember to modify the 
			// remaining cents for the next level
			curr.remove(curr.size() - 1); // for back-tracking
		}
	}   



}
