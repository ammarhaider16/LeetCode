class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<List<Integer>> uniques = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int target = -a;

            int start = 0;
            int end = nums.length - 1;

            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                int b = nums[start];
                int c = nums[end];

                if (b + c > target)
                    end--;
                else if (b + c < target)
                    start++;
                else {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(a, b, c));
                    Collections.sort(triplet);
                    if (!uniques.contains(triplet)) {
                        triplets.add(triplet);
                        uniques.add(triplet);
                    }
                    start++;
                    end--;
                }
            }
        }
        return triplets;
    }
}