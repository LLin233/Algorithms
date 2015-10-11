import java.util.*;
/**
*   Given an array of strings, return all groups of strings that are anagrams.
*
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
      List<String> groups = new ArrayList<String>();
      if (strs==null||strs.length==0) {
          return groups;
      }
      Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
      for (String str : strs) {
          char[] chars = str.toCharArray();
          Arrays.sort(chars);
          String key = new String(chars);
          if(map.containsKey(key)) {
             if(map.get(key).size() == 1) {
                groups.add(map.get(key).get(0)); //do not forget to add the first word
             }
                map.get(key).add(str);
                groups.add(str);
          } else {
                //first word
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(key, tempList);
          }
      }
      return groups;
    }
}


/**
*
*	Leetcode version
*
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> groups = new ArrayList<List<String>>();
       if (strs == null || strs.length == 0) {
       		return groups;
       }
       Arrays.sort(strs);
       Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
       for (String str : strs) {
           char[] chars = str.toCharArray();
           Arrays.sort(chars);
           String key = new String(chars);
           if(map.containsKey(key)) {
               map.get(key).add(str);
           } else {
                ArrayList<String> group = new ArrayList<String>();
                group.add(str);
                map.put(key, group);
           }
       }
       for(List<String> val : map.values()) {
            groups.add(val);
        }
       return groups;
    }
}