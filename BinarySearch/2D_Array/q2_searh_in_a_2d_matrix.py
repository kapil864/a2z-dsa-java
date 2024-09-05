def binary_search_array(array: list, key: int) -> int:
    st = 0
    ed = len(array) - 1

    while st <= ed:
        mid = (st + ed) >> 1

        if array[mid] == key:
            return mid
        elif array[mid] < key:
            st = mid + 1
        else:
            ed = mid - 1


def search_matrix(matrix: list[list], key: int) -> list:
    row = len(matrix)
    col = len(matrix[0])

    rowst = 0
    rowed = row-1

    while (rowst <= rowed):
        row_mid = (rowst + rowed) >> 1
        if key == matrix[row_mid][0]:
            return [row_mid, 0]
        elif key == matrix[row_mid][col-1]:
            return [row_mid, col-1]
        elif key > matrix[row_mid][0] and key < matrix[row_mid][col-1]:
            return [row_mid, binary_search_array(matrix[row_mid], key)]
        elif key < matrix[row_mid][0]:
            rowed = row_mid - 1
        else:
            rowst = row_mid + 1


if __name__ == "__main__":
    m = int(input())
    n = int(input())

    matrix = []
    for i in range(m):
        numbers = input().split(" ")
        numbers = [int(number) for number in numbers]
        matrix.append(numbers)

    key = int(input())
    print(search_matrix(matrix, key))
