class Solution {

    public boolean isPalindrome(String s) {
        
        // string processing
        String processed = "";
        for (int i = 0; i<s.length();i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) processed+=s.charAt(i);
        }
        processed = processed.toLowerCase();
        System.out.println(processed);

        // loop for palindrome check
        for (int i = 0; i<processed.length()/2; i++) {
            if (processed.charAt(i) != processed.charAt(processed.length() - 1 - i)) return false;
        }
        
        return true;
    }
}