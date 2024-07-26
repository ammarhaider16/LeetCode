class Solution {

    public boolean isPalindrome(String s) {

        char[] alphaNumChars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

        int start = 0;
        int end = alphaNumChars.length - 1;

        while (start < end) {
            if (alphaNumChars[start] != alphaNumChars[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}