class Solution {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {

        int result;

        if (cache.containsKey(n))
            return (cache.get(n));

        if (n <= 2) {
            result = n;
        } else {
            result = climbStairs(n - 2) + climbStairs(n - 1);
        }

        cache.put(n, result);
        return result;
    }
}