import java.util.*;
class Solution {
    public String solution(String p) {
        
        String answer = getCorrectParentheses(p);
        return answer;
    }
 
        public static boolean isCorrectParenthesis(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push('(');
            } else if (string.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static String getCorrectParentheses(String balancedParenthesesString) {
        if (isCorrectParenthesis(balancedParenthesesString)) {
            return balancedParenthesesString;
        } else {
            return changeToCorrectParenthesis(balancedParenthesesString);
        }
    }
    
    public static String changeToCorrectParenthesis(String balancedParenthesesString) {
        if (balancedParenthesesString.equals("")) {
            return "";
        }

        String[] uv = separateToUV(balancedParenthesesString);
        String u = uv[0];
        String v = uv[1];
        

        if (isCorrectParenthesis(u)) {
            return u + changeToCorrectParenthesis(v);
        } else {
            return "(" + changeToCorrectParenthesis(v) + ")" + reverseParenthesis(u.substring(1, u.length() - 1));
        }
    }
    
    public static String reverseParenthesis(String string) { // 뒤집는
        StringBuilder reversedString = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (ch == '(') {
                reversedString.append(')');
            } else if (ch == ')') {
                reversedString.append('(');
            }
        }
        return reversedString.toString();
    }
    
    public static String[] separateToUV(String string) {
        Queue<Character> queue = new java.util.LinkedList<>();
        for (char ch : string.toCharArray()) {
            queue.add(ch);
        }
        int leftParenthesisCount = 0, rightParenthesisCount = 0;
        StringBuilder u = new StringBuilder();
        String v = "";
        
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            u.append(ch); // )
            if (ch == '(') {
                leftParenthesisCount += 1;
            }
            if (ch == ')') {
                rightParenthesisCount += 1;
            }
            
            if (leftParenthesisCount == rightParenthesisCount) {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        v = sb.toString(); // '('
        return new String[]{u.toString(), v};
    }
    
}