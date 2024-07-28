class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        ArrayList<Integer> srtd = new ArrayList<>();
        int a = 0;
        int b = 0;
        while (a < l1 && b < l2) {
            if (nums1[a] < nums2[b]) {
                srtd.add(nums1[a]);
                a++;
            } else if (nums1[a] > nums2[b]) {
                srtd.add(nums2[b]);
                b++;
            } else {
                srtd.add(nums1[a]);
                srtd.add(nums2[b]);
                a++;
                b++;
            }
        }
        while (a < l1) {
            srtd.add(nums1[a]);
            a++;
        }
        while (b < l2) {
            srtd.add(nums2[b]);
            b++;
        }
        double median = 0;
        int end = srtd.size() - 1;
        if (end % 2 != 0) {
            median = (srtd.get(end / 2) + srtd.get((end / 2) + 1)) / (double) 2;
        } else {
            median = (double) srtd.get(end / 2);
        }
        return median;
    }
}