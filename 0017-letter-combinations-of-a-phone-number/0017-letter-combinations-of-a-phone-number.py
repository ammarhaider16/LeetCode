class Solution(object):

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """

        if (len(digits)==0):
            return []

        self.digits = digits
        self.combinations = []
        prefix = ""
        self.helper(prefix, 0)
        return self.combinations


    def helper(self,prefix,idx):
        if (idx == len(self.digits)):
            self.combinations.append(prefix)
            return
        nextChars = self.letters[self.digits[idx]]
        for char in nextChars:
            self.helper(prefix+char, idx+1)
        return
        

    letters = {
        "2":["a","b","c"],
        "3":["d","e","f"],
        "4":["g","h","i"],
        "5":["j","k","l"],
        "6":["m","n","o"],
        "7":["p","q","r","s"],
        "8":["t","u","v"],
        "9":["w","x","y","z"]
    }