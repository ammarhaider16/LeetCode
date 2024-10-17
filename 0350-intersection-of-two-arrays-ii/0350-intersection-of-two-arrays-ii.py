from collections import Counter

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        
        final = []
        freqs1 = Counter(nums1)
        freqs2 = Counter(nums2)

        if (len(freqs1) <= len(freqs2)):
            for item, count in freqs1.items():
                final += [item]*min(count, freqs2[item])
        else: 
            for item, count in freqs2.items():
                final += [item]*min(count, freqs1[item])

        return final