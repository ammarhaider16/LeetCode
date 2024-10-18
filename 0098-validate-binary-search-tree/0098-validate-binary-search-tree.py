# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.root = root
        return self.validateBSTHelper(self.root, float('inf'), float('-inf'))

    def validateBSTHelper(self, node, maxVal, minVal):
        if node == None:
            return True

        if (node.left.val < node.val if node.left else True) and (node.left.val > minVal if node.left else True) and (node.right.val > node.val if node.right else True) and (node.right.val < maxVal if node.right else True):
            return self.validateBSTHelper(node.left, min(maxVal, node.val), minVal) and self.validateBSTHelper(node.right, maxVal, max(minVal, node.val)) 
        else:
            return False

