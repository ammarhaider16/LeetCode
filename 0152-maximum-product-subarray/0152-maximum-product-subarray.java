class Solution {
        public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int thisProd = 1;
        for (int i = 0; i < nums.length; i++) {
            thisProd *= nums[i];
            if (thisProd > maxProd)
                maxProd = thisProd;
            if (thisProd == 0)
                thisProd = 1;
        }

        thisProd = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            thisProd *= nums[i];
            if (thisProd > maxProd)
                maxProd = thisProd;
            if (thisProd == 0)
                thisProd = 1;
        }
        return maxProd;
    }
}