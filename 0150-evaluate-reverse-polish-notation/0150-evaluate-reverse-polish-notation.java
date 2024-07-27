class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> current = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")) {
                current.push(Integer.parseInt(c));
            } else {
                int after = current.pop();
                int before = current.pop();
                if (c.equals("+"))
                    current.push(before + after);
                else if (c.equals("-"))
                    current.push(before - after);
                else if (c.equals("*"))
                    current.push(before * after);
                else if (c.equals("/"))
                    current.push(before / after);
            }
        }
        return current.pop();
    }
}