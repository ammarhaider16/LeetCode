
class Solution:
    def generateParenthesis(self, n: int):
        all_combinations = []
        def generate(n_available, n_open, current_sequence):
            if n_available == 0 and n_open == 0:
                all_combinations.append("".join(sequence))
            if n_available > 0:
                current_sequence.append("(")
                generate(n_available - 1, n_open + 1, current_sequence)
                current_sequence.pop()	
            if n_open > 0:
                current_sequence.append(")") 
                generate(n_available, n_open - 1, current_sequence)
                current_sequence.pop()
        sequence = []
        generate(n, 0, sequence)
        return all_combinations