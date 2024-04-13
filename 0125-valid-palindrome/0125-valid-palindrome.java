class Solution {

    public boolean isPalindrome(String s) {
        
        // Two-Pointer Approach
        int start = 0;
        int end = s.length() - 1;

        for (start = 0; start<end; start++, end--) {

            if (!((s.charAt(start) >= '0' && s.charAt(start) <= '9') || (s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= 'A' && s.charAt(start) <= 'Z'))) {
                end++;
                continue;
            }

            if (!((s.charAt(end) >= '0' && s.charAt(end) <= '9') || (s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= 'A' && s.charAt(end) <= 'Z'))) {
                start--;
                continue;
            }

            if (!((""+s.charAt(start)).toLowerCase().equals((""+s.charAt(end)).toLowerCase()))) return false;

        }
        
        return true;
    }
}