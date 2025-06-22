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
        differences = set()
        return self.twoSumTree(root, differences, k)
    
    def twoSumTree(self, node, differences, target):
        if node.left:
            leftFound = self.twoSumTree(node.left, differences, target)
            if leftFound:
                return True

        if node.val in differences:
            return True
        differences.add(target - node.val)
               
        if node.right:
            rightFound = self.twoSumTree(node.right, differences, target)
            if rightFound:
                return True
        
        return False
