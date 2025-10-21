class Solution:
    def diameterOfBinaryTree(self, root):
        self.diameter = 0
        def get_diameter(current):
            if not current:
                return 0
            left_max = get_diameter(current.left)
            right_max = get_diameter(current.right)
            if (left_max + right_max) > self.diameter:
                self.diameter = left_max + right_max
            return 1 + max(left_max, right_max)
        get_diameter(root)
        return self.diameter
