# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def minDepth(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        if not root:
            return 0
        
        BSTqueue = deque()
        BSTqueue.appendleft((root, 1))
        while len(BSTqueue) > 0:
            node, depth = BSTqueue.pop()
            if node.left:
                BSTqueue.appendleft((node.left, depth+1))
            if node.right:
                BSTqueue.appendleft((node.right, depth+1))
            if (not node.left) and (not node.right):
                return depth
        return 0  # Guaranteed to never occur on a valid tree
  