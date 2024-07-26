class Solution {

    public boolean isPalindrome(String s) {

        ArrayList<Character> alphaNumChars = new ArrayList<>();
        String lowerStr = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char c = lowerStr.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122))
                alphaNumChars.add(c);
        }

        int start = 0;
        int end = alphaNumChars.size() - 1;

        System.out.println(alphaNumChars);

        while (start < end) {
            if (alphaNumChars.get(start) != alphaNumChars.get(end))
                return false;
                
            start++;
            end--;
        }
        return true;
    }
}