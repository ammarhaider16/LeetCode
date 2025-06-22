# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: bool
        """
        vals = []
        self.arrayFromBST(root, vals)
        return self.twoSumStandard(vals, k)

    def arrayFromBST(self, root, vals):
        if root.left:
            self.arrayFromBST(root.left, vals)
        vals.append(root.val)
        if root.right:
            self.arrayFromBST(root.right, vals)
        return
    
    def twoSumStandard(self, vals, target):
        differences = set()
        for val in vals:
            if val in differences:
                return True
            differences.add(target - val)
        return False
