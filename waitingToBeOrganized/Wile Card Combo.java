import java.util.*;
/**
*   Given a string with only '0','1','?', generate the all strings that match this wile card.
*	For example, given
*	s = "10?01??",
*	result = [1000100, 1000101, 1000110, 1000111, 1010100, 1010101, 1010110, 1010111]
*
*/

public class Solution {
    public List<String> replaceQuestionMark(String s) {
	    int i = s.indexOf("?");
	    List<String> res = new LinkedList<String>();
	    if (i == -1) res.add(s);
	    else {
	        res.addAll(replaceQuestionMark(s.substring(0, i) + "0" + s.substring(i+1)));
	        res.addAll(replaceQuestionMark(s.substring(0, i) + "1" + s.substring(i+1)));
	    }
	    return res;
	}
}
