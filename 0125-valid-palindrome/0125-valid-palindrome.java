class Solution {
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char c1 = s.charAt(start);
            if (!Character.isLetterOrDigit(c1)) {
                start++;
                continue;
            }

            char c2 = s.charAt(end);
            if (!Character.isLetterOrDigit(c2)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2))
                return false;

            start++;
            end--;
        }
        return true;
    };
}