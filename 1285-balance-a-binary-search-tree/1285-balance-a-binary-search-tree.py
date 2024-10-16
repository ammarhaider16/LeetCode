# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def balanceBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.nums = []
        self.traverseBSTInorder(root)
        return createBSTFromSortedArray(self.nums, 0, len(self.nums)-1)


    def traverseBSTInorder(self, node):
        if (node == None):
            return self.nums
        self.traverseBSTInorder(node.left)
        self.nums.append(node.val)
        self.traverseBSTInorder(node.right)
        return

def createBSTFromSortedArray(nums, start, end):
    if (start>end):
        return None
    elif (start==end):
        return TreeNode(val=nums[start])
    elif (end-start==1):
        return TreeNode(val=max(nums[start],nums[end]), left=TreeNode(val=min(nums[start],nums[end])))
    elif (end-start==2):
        return TreeNode(val=nums[start+1], left=TreeNode(val=nums[start]), right=TreeNode(val=nums[end]))
    
    mid = (start+end) // 2

    return TreeNode(val=nums[mid], left=createBSTFromSortedArray(nums,start,mid-1), right=createBSTFromSortedArray(nums, mid+1,end))

