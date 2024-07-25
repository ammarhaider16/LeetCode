class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixMultiples = new int[len];
        int[] suffixMultiples = new int[len];

        prefixMultiples[0] = nums[0];
        suffixMultiples[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            prefixMultiples[i] = nums[i] * prefixMultiples[i - 1];
        }

        for (int j = len - 2; j >= 0; j--) {
            suffixMultiples[j] = nums[j] * suffixMultiples[j + 1];
        }

        int[] products = new int[len];

        products[0] = suffixMultiples[1];
        products[len - 1] = prefixMultiples[len - 2];
        for (int k = 1; k < len - 1; k++) {
            products[k] = prefixMultiples[k - 1] * suffixMultiples[k + 1];
        }
        return products;
    }
}