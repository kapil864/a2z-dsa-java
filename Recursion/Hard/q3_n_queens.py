
import copy
from typing import List

def isValid(row, col, board):
    n = len(board)

    # checking row and column
    for i in range(n):
        if board[row][i] == 'Q' or board[i][col] == 'Q':
            return False
    
    i,j = row, col
    #upward cross right
    while i >= 0 and j < n:
        if board[i][j] == 'Q':
            return False
        i -= 1
        j += 1
    
    i,j = row, col
    #upward cross left
    while i >= 0 and j >= 0:
         if board[i][j] == 'Q':
            return False
         j -= 1
         i -= 1

    i,j = row, col
    #downward cross left
    while i < n and j >= 0:
        if board[i][j] == 'Q':
            return False
        i += 1
        j -= 1

    i,j = row, col
    # downward cross right
    while i <n and j < n:
        if board[i][j] == 'Q':
            return False
        i += 1
        j += 1

    return True 

def helper(col, board : List[List[str]], ans):

    if col == len(board):
        ans.append(copy.deepcopy(board))
        return

    for i in range(len(board)):
        if isValid(i, col, board):
            board[i] = board[i][:col] + 'Q' + board[i][col+1:]
            helper(col+1, board, ans)
            board[i] = board[i][:col] + '.' + board[i][col+1:]

def solveNQueens( n: int) -> List[List[str]]:
    board = [ '.'*n for _ in range(n)]
    ans = []
    helper(0,board, ans)
    return ans

if __name__  == "__main__":
    n = int(input())
    print(solveNQueens(n))