import java.util.*;
/**
*   Given a array contains players' name , generate the match schedule.
*	For example, given
*	players = {'A','B','C','D'};
*	schedule = [[A, B], [A, C], [A, D], [B, C], [B, D], [C, D]]
*
*/

public class Solution {
    public List<List<Character>> tourament(char[] players) {
		List<List<Character>> result = new ArrayList<List<Character>>();
		if (players == null) {
			return result;
		}
		helper(result, new ArrayList<Character>(), players, 0);
		return result;
	}
	private void helper(List<List<Character>> result, List<Character> path, char[] players, int position) {
		if (path.size() == 2) {
			result.add(new ArrayList<Character>(path));
			return;
		}
		for (int i = position; i < players.length; i++) {
			path.add(players[i]);
			helper(result, path, players, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
