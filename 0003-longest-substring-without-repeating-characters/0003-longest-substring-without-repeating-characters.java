class Solution {
        public int lengthOfLongestSubstring(String s) {

        HashSet<Character> chars = new HashSet<>();

        int maxLen = 0;
        int head = 0;

        for (int tail = 0; tail < s.length(); tail++) {
            Character c = s.charAt(tail);

            if (chars.contains(c)) {
                while (chars.contains(c)) {
                    chars.remove(s.charAt(head));
                    head++;
                }
            }
            chars.add(c);
            maxLen = Math.max(maxLen, chars.size());
        }

        return maxLen;
    }
}