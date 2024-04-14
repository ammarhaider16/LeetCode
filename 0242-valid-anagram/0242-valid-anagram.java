class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> letters = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if ((!letters.containsKey(s.charAt(i))))
                letters.put((Character) s.charAt(i), 1);
            else
                letters.put(s.charAt(i), letters.get((s.charAt(i))) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            System.out.println(letters);
            if (letters.get(t.charAt(i)) != null && (int) letters.get(t.charAt(i)) > 0)
                letters.put(t.charAt(i), (int) letters.get((t.charAt(i))) - 1);
            else
                return false;
        }
        return true;
    }
}