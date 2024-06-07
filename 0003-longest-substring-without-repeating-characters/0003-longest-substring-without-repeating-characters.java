class Solution {
    public int lengthOfLongestSubstring(String s) {
        String longestSubStr = "";

        for (int i = 0; i<s.length(); i++) {
            String thisSubStr = "";
            for (int j = i; j<s.length(); j++) {
                if (thisSubStr.indexOf(s.charAt(j)) < 0 ) {
                    thisSubStr += s.charAt(j);
                }
                else break;
            }
            if (thisSubStr.length()>longestSubStr.length()) longestSubStr = thisSubStr;
        }

        return longestSubStr.length();

    }
}