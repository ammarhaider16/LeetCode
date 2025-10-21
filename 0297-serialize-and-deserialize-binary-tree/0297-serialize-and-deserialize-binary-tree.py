# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string."""
        res = []

        def dfs(node):
            if not node:
                res.append("N")
                return
            res.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)
        return ",".join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree."""
        vals = data.split(",")
        self.index = 0

        def dfs():
            if vals[self.index] == "N":
                self.index += 1
                return None
            node = TreeNode(int(vals[self.index]))
            self.index += 1
            node.left = dfs()
            node.right = dfs()
            return node

        return dfs()
