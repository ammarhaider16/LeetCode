class Solution {
    public boolean isValid(String s) {

        Stack braks = new Stack<Character>();
        System.out.println(braks.size());

        for (int i = 0; i < s.length(); i++) {
            if (braks.size() == 0) {
                braks.push(s.charAt(i));
                continue;
            }

            Character reversed;
            if (s.charAt(i) == ')')
                reversed = '(';
            else if (s.charAt(i) == ']')
                reversed = '[';
            else
                reversed = '{';

            if ((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') && (char) braks.peek() != reversed)
                return false;
            else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                braks.pop();
            } else
                braks.push(s.charAt(i));

        }

        if (braks.size() != 0)
            return false;

        return true;
    }    
}