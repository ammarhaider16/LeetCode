class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                brackets.push(c);
            else if (brackets.isEmpty())
                return false;
            else if (c == ']') {
                if (brackets.pop() != '[')
                    return false;
            } else if (c == '}') {
                if (brackets.pop() != '{')
                    return false;
            } else if (c == ')') {
                if (brackets.pop() != '(')
                    return false;
            }
        }
        if (!brackets.isEmpty())
            return false;
        return true;
    }
}