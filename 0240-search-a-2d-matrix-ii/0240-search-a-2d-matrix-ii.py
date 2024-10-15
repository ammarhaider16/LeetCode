class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        rowStart = 0
        rowEnd = len(matrix)-1
        colStart = 0
        colEnd = len(matrix[0]) - 1
        return searchMatrixHelper(matrix, target, rowStart, rowEnd, colStart, colEnd)


    
def searchMatrixHelper(matrix, target, rowStart, rowEnd, colStart, colEnd):

    if (rowStart>rowEnd or colStart>colEnd):
        return False
    elif (colStart==colEnd and rowStart==rowEnd):
        return matrix[rowStart][colStart] == target

    rowMid = (rowStart+rowEnd) // 2
    colMid = (colStart+colEnd) // 2
    mid = matrix[rowMid][colMid]

    if (mid == target):
        return True
    elif (mid>target):
        top = searchMatrixHelper(matrix, target, rowStart, rowMid-1, colStart, colEnd)
        left = searchMatrixHelper(matrix, target, rowMid, rowEnd, colStart,colMid-1)
        return top or left
    
    elif (mid<target):
        bottom = searchMatrixHelper(matrix, target, rowMid+1, rowEnd, colStart, colMid)
        right = searchMatrixHelper(matrix, target, rowStart, rowEnd, colMid+1,colEnd)
        return bottom or right