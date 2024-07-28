class Solution {
    List<String> validCombinations = new ArrayList<>();
    Stack<Character> combinationStack = new Stack<>();
    int maxCount = 0;

    public List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closedCount = 0;
        maxCount = n;
        handleCombination(openCount, closedCount);
        return validCombinations;
    }

    private void handleCombination(int openCount, int closedCount) {
        if (openCount < maxCount) {
            combinationStack.push('(');
            handleCombination(openCount + 1, closedCount);
            combinationStack.pop();
        }
        if (closedCount < openCount) {
            combinationStack.push(')');
            handleCombination(openCount, closedCount + 1);
            combinationStack.pop();
        }
        if (openCount == maxCount && closedCount == maxCount) {
            validCombinations.add(stackToString(combinationStack));
        }
    }

    private String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}