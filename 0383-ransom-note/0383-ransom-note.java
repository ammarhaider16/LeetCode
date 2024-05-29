class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();

        for (int i = 0; i < magazine.length(); i++) {
            if (!letters.containsKey(magazine.charAt(i))) {
                letters.put(magazine.charAt(i), 1);
            } else {
                letters.put(magazine.charAt(i), letters.get(magazine.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if ((!letters.containsKey(ransomNote.charAt(i))) || (letters.get(ransomNote.charAt(i)) <= 0))
                return false;
            else
                letters.put(ransomNote.charAt(i), letters.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }
}