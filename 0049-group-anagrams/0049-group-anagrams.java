import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            List<String> anagrams = groups.get(sorted);
            if (anagrams != null) {
                anagrams.add(str);
            } else {
                List<String> newList = new ArrayList<>(Arrays.asList(str));
                groups.put(sorted, newList);
            }
        }
        List<List<String>> finalList = new ArrayList<>();
        for (String group : groups.keySet()) {
            finalList.add(groups.get(group));
        }
        return finalList;
    }

    /*
     * public List<List<String>> groupAnagrams(String[] strs) {
     * HashMap<HashMap<Character, Integer>, List<String>> groups = new HashMap<>();
     * 
     * for (String str : strs) {
     * HashMap<Character, Integer> strChars = new HashMap<>();
     * for (Character c : str.toCharArray()) {
     * Integer count = strChars.get(c);
     * if (count != null) {
     * strChars.put(c, count + 1);
     * } else {
     * strChars.put(c, 1);
     * }
     * }
     * List<String> anagrams = groups.get(strChars);
     * if (anagrams != null) {
     * anagrams.add(str);
     * } else {
     * List<String> newList = new ArrayList<>(Arrays.asList(str));
     * groups.put(strChars, newList);
     * }
     * }
     * 
     * List<List<String>> finalList = new ArrayList<>();
     * for (HashMap<Character, Integer> anagramMap : groups.keySet()) {
     * finalList.add(groups.get(anagramMap));
     * }
     * return finalList;
     * }
     */

}
