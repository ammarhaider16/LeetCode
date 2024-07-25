class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> strChars = new HashMap<>();
            for (Character c : str.toCharArray()) {
                Integer count = strChars.get(c);
                if (count != null) {
                    strChars.put(c, count + 1);
                } else {
                    strChars.put(c, 1);
                }
            }
            List<String> anagrams = groups.get(strChars);
            if (anagrams != null) {
                anagrams.add(str);
            } else {
                List<String> newList = new ArrayList<>(Arrays.asList(str));
                groups.put(strChars, newList);
            }
        }

        List<List<String>> finalList = new ArrayList<>();
        for (HashMap<Character, Integer> anagramMap : groups.keySet()) {
            finalList.add(groups.get(anagramMap));
        }
        return finalList;
    }
}