# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        PS = 0
        PE = len(preorder) - 1
        IS = 0
        IE = len(inorder) - 1
        return buildTreeHelper(preorder, inorder, PS, PE, IS, IE)


def buildTreeHelper(preorder, inorder, PS, PE, IS, IE):
    if (PS>PE or IS>IE):
        return None
    
    val = preorder[PS]

    valInorderIdx = IS

    while(valInorderIdx<=IE):
        if inorder[valInorderIdx] == val:
            break
        valInorderIdx += 1
    
    leftDistance = valInorderIdx - IS

    return TreeNode(val=val, left=buildTreeHelper(preorder, inorder, PS+1, PS+leftDistance, IS, IS+leftDistance-1), right=buildTreeHelper(preorder, inorder, PS+leftDistance+1, PE, IS+leftDistance+1,IE))
    
