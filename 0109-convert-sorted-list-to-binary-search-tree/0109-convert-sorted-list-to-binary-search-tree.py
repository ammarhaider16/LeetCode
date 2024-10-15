# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[TreeNode]
        """
        nums = []
        current = head
        while(current!=None):
            nums.append(current.val)
            current = current.next
        return SATBHelper(nums, 0, len(nums)-1)

def SATBHelper(nums, S, E):
    if (S>E):
        return None
    elif (S==E):
        return TreeNode(val=nums[S])
    elif (E-S==1):
        return TreeNode(val=max(nums[S],nums[E]), left=TreeNode(val=min(nums[S],nums[E])))
    elif (E-S==2):
        return TreeNode(val=nums[S+1], left=TreeNode(val=nums[S]), right=TreeNode(val=nums[E]))
    
    mid = (S+E) // 2

    return TreeNode(val=nums[mid], left=SATBHelper(nums,S,mid-1), right=SATBHelper(nums, mid+1,E))


    