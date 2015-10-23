import java.util.*;
/**
*   Given an absolute path for a file (Unix-style), simplify it.
    For example,

    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
*
*/

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while(i < path.length()) {
            StringBuilder name = new StringBuilder();
            while(i < path.length() && path.charAt(i) != '/') {
                name.append(path.charAt(i++));
            }
            String str = name.toString();
            if(!str.isEmpty()) {
                if(str.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if(str.equals(".")) {
                    continue;
                } else {
                    stack.push(str);
                }
            }
            i++;
        }

        StringBuilder rst = new StringBuilder();
        for(Object name : stack.toArray()) {
            rst.append("/").append(name);
        }

        return rst.length() == 0 ? "/" : rst.toString();
    }
}
