class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        Map<Character, ArrayList<Integer>> letters = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            if ((!letters.containsKey(s.charAt(i))))
                letters.put((Character) s.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
            else
                (letters.get(s.charAt(i))).add(i);
        }

        for (int i = 0; i < t.length(); i++) {
            if (letters.get(t.charAt(i)) != null && letters.get(t.charAt(i)).size() > 0)
                letters.get(t.charAt(i)).remove(0);
            else
                return false;
        }
        return true;
    }
}