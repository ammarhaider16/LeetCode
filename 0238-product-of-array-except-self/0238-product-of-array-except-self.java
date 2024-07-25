class Solution {
    public int[] productExceptSelf(int[] nums) {
        HashMap<Integer, Integer> prefixMultiples = new HashMap<>();
        HashMap<Integer, Integer> suffixMultiples = new HashMap<>();
        int len = nums.length;

        prefixMultiples.put(0, nums[0]);
        suffixMultiples.put(len - 1, nums[len - 1]);
        for (int i = 1; i < len; i++) {
            prefixMultiples.put(i, nums[i] * prefixMultiples.get(i - 1));
        }

        for (int j = len - 2; j >= 0; j--) {
            suffixMultiples.put(j, nums[j] * suffixMultiples.get(j + 1));
        }

        int[] products = new int[len];

        products[0] = suffixMultiples.get(1);
        products[len - 1] = prefixMultiples.get(len - 2);
        for (int k = 1; k < len - 1; k++) {
            products[k] = prefixMultiples.get(k - 1) * suffixMultiples.get(k + 1);
        }
        return products;
    }
}