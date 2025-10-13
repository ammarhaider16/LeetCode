class Solution:
    def combine(self, n, k):
        if n<k:
            return []
        all_combinations = []
        def make_combination(n, last_selected, remaining, combination):
            if remaining == 0:
                all_combinations.append(combination[:])
            if last_selected == n:
                return 
            for i in range(last_selected+1, n+1):
                combination.append(i)
                make_combination(n, i, remaining - 1, combination)
                combination.pop()
        make_combination(n, 0, k, [])
        return all_combinations