class Solution:
    def countSubstrings(self, s: str) -> int:
        count, n = 0, len(s)
        valid = set()
        for i in range(n):
            valid.add((i, i))
            count += 1
        for i in range(n-1):
            if s[i] == s[i+1]:
                valid.add((i, i+1))
                count += 1
        for size in range(3, n+1):
            for i in range(n - size + 1):
                if s[i] == s[i+size-1] and (i+1, i+size-2) in valid:
                    count += 1
                    valid.add((i, i+size-1))
        return count