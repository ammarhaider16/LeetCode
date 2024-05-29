class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (!letters.containsKey(s.charAt(i))) {
                letters.put(s.charAt(i), 1);
            } else {
                letters.put(s.charAt(i), letters.get(s.charAt(i)) + 1);
            }
        }

        int evenCount = 0;
        boolean add1 = false;

        for (Character c : letters.keySet()) {
            int freq = letters.get(c);
            if (freq % 2 == 0)
                evenCount += freq;
            else if (freq % 2 != 0) {
                evenCount += freq - 1;
                add1 = true;
            }
        }
        return add1 ? evenCount + 1 : evenCount;

    }
}