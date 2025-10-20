class Solution:
    def kthSmallest(self, root, k):
        self.res = -1 
        def search(current, parent_smaller):
            if not current:
                return 0
            left_size = search(current.left, parent_smaller)
            curr_smaller = left_size + parent_smaller
            if curr_smaller == (k - 1):
                self.res = current.val
            right_size = search(current.right, curr_smaller + 1)
            return left_size + 1 + right_size
        search(root, 0)
        return self.res