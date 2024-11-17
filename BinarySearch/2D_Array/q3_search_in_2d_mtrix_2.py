

def search_matrix(matrix: list[list], key: int) -> list:
    row = 0
    col = len(matrix[0]) - 1

    while (row < len(matrix) and col >= 0):

        if matrix[row][col] == key:
            return [row, col]
        elif key > matrix[row][col]:
            row += 1
        else:
            col -= 1


if __name__ == "__main__":
    m = int(input())
    n = int(input())

    matrix = []
    for i in range(m):
        numbers = list(map(int,input().split(" ")))
        matrix.append(numbers)

    key = int(input())
    print(search_matrix(matrix, key))


# # Sample input
# [[1, 4, 7, 11, 15],
#  [2, 5, 8, 12, 19],
#  [3, 6, 9, 16, 22],
#  [10, 13, 14, 17, 24],
#  [18, 21, 23, 26, 30]
# ]
# # Find the number 5
