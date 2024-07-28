class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] medianArr = new int[nums1.length+nums2.length];

        int nums1Idx = 0;
        int nums2Idx = 0;

        for (int i = 0; i<medianArr.length;i++) {

            if (nums1Idx < nums1.length && nums2Idx < nums2.length) {
                if (nums1[nums1Idx] < nums2[nums2Idx]) {
                    medianArr[i] = nums1[nums1Idx];
                    nums1Idx ++;
                }

                else if (nums1[nums1Idx] == nums2[nums2Idx]) {
                    medianArr[i] = nums1[nums1Idx];
                    medianArr[i+1] = nums2[nums2Idx];
                    nums1Idx++;
                    nums2Idx++;
                    i++;
                }

                else if (nums1[nums1Idx] > nums2[nums2Idx]) {
                    medianArr[i] = nums2[nums2Idx];
                    nums2Idx++;
                }

            }

            else if (nums1Idx < nums1.length) {
                medianArr[i] = nums1[nums1Idx];
                nums1Idx ++;
            }

            else if (nums2Idx < nums2.length) {
                medianArr[i] = nums2[nums2Idx];
                nums2Idx++;
            }
        }

        System.out.println(Arrays.toString(medianArr));
        
        if (!(medianArr.length%2==0)) return medianArr[medianArr.length/2];
        
        int sum = medianArr[medianArr.length/2] + medianArr[(medianArr.length/2)-1];
        return (double)sum / 2;
    }
}