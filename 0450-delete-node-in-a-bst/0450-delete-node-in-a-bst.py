# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def deleteNode(self, root, key):
        if not root:
            return None
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            # Found node to delete
            if not root.left:
                return root.right
            if not root.right:
                return root.left
            # Node with two children - use inorder successor
            minLargerNode = self.getMin(root.right)
            root.val = minLargerNode.val
            root.right = self.deleteNode(root.right, minLargerNode.val)
        return root
    
    def getMin(self, node):
        while node.left:
            node = node.left
        return node
