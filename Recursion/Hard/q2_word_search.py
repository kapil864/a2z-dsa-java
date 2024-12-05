

from typing import List


def helper(rowI, colI, wIndex, board, word, m, n):
    if wIndex == len(word):
        return True

    if (rowI == m) or (colI == n) or (rowI < 0) or (colI < 0) or (board[rowI][colI] != word[wIndex]) or (board[rowI][colI] == 0):
        return False
    temp = board[rowI][colI]
    board[rowI][colI] = 0

    top = helper(rowI-1, colI, wIndex+1, board, word, m, n)

    bottom = helper(rowI+1, colI, wIndex+1, board, word, m, n)

    left = helper(rowI, colI-1, wIndex+1, board, word, m, n)

    right = helper(rowI, colI+1, wIndex+1, board, word, m, n)
    board[rowI][colI] = temp
    return top or bottom or left or right


def exist(board: List[List[str]], word: str) -> bool:

    wIndex = 0
    m = len(board)
    n = len(board[0])
    for i in range(m):
        for j in range(n):
            if board[i][j] == word[wIndex]:
                if helper(i, j, wIndex, board, word, m, n):
                    return True
    return False


if __name__ == "__main__":

    m = int(input())
    n = int(input())

    board = []
    for i in range(m):
        row = input().split(' ')
        board.append(row)
    word = input()
    print(exist(board, word))
