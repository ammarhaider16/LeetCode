# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        PS = 0
        PE = len(postorder) - 1
        IS = 0
        IE = len(inorder) - 1
        return buildTreeHelper(inorder, postorder, PS, PE, IS, IE)


def buildTreeHelper(inorder, postorder, PS, PE, IS, IE):
    if (PS>PE or IS>IE):
        return None
    
    val = postorder[PE]

    valInorderIdx = IS

    while(valInorderIdx<=IE):
        if inorder[valInorderIdx] == val:
            break
        valInorderIdx += 1


    root = TreeNode(val=val)
    
    leftDistance = valInorderIdx - IS

    leftIS = IS
    leftIE = IS+leftDistance-1
    leftPS = PS
    leftPE = PS+leftDistance-1

    rightIS = IS+leftDistance+1
    rightIE = IE
    rightPS = PS+leftDistance
    rightPE = PE-1
    

    root.left= buildTreeHelper(inorder, postorder, leftPS, leftPE, leftIS, leftIE)
    root.right= buildTreeHelper(inorder, postorder, rightPS, rightPE, rightIS, rightIE)

    return root
