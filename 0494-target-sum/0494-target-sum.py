class Solution:
    def findTargetSumWays(self, nums, target):
        endpoint = sum(nums)
        if abs(target) > endpoint:
            return 0
        mem = {}
        def find_target_approaches(i, k):
            if i == 0:
                if (nums[0] == 0 and k == 0):
                    return 2
                elif (nums[0] == abs(k)): 
                    return 1
                else:
                    return 0
            elif (i, k) in mem:
                return mem[(i, k)] 
            else:
                total = find_target_approaches(i-1, k - nums[i]) + find_target_approaches(i-1, k + nums[i])
                mem[(i, k)] = total
                return total
        return find_target_approaches(len(nums) - 1, target)

    