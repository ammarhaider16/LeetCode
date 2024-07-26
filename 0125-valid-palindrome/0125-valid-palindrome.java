class Solution {


    public boolean isPalindrome(String s) {
        String lowerStr = s.toLowerCase();

        int start = 0;
        int end = lowerStr.length() - 1;

        while (start < end) {
            char c1 = lowerStr.charAt(start);
            if (!Character.isLetterOrDigit(c1)) {
                start++;
                continue;
            }

            char c2 = lowerStr.charAt(end);
            if (!Character.isLetterOrDigit(c2)) {
                end--;
                continue;
            }
            if (c1 != c2)
                return false;

            start++;
            end--;
        }
        return true;
    };
}