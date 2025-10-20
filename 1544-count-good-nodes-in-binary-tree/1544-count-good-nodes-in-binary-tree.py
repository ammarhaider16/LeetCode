class Solution:
    def goodNodes(self, root):
        def count_good_nodes(current, max_anc):
            if not current:
                return 0
            good_count = 1 if current.val >= max_anc else 0
            updated_max = max(current.val, max_anc)
            good_count += count_good_nodes(current.left, updated_max) + count_good_nodes(current.right, updated_max)
            return good_count
        return count_good_nodes(root, root.val)