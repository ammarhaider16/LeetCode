# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        return self.LCAHelper(root, p, q)
        
    def LCAHelper(self, node, p, q):

        val = node.val
        pVal = p.val
        qVal = q.val

        if (pVal > val and qVal > val):
            return self.LCAHelper(node.right, p, q)
        elif (pVal < val and qVal < val):
            return self.LCAHelper(node.left, p, q)
        else:
            return node