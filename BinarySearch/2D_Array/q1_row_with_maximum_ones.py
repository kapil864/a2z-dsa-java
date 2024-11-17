
# count the number of ones in each row and return the one with greates number of ones
# time complexity = O(n^2), space complexity = O(1)
def get_row_with_max_ones_brute(matrix: list[list]) -> int:
    rows = len(martix)
    ans = -1
    max_number_of_ones = 0

    for i in range(rows):
        number_of_ones = sum(martix[i])
        if max(max_number_of_ones, number_of_ones) > max_number_of_ones:
            max_number_of_ones = max(max_number_of_ones, number_of_ones)
            ans = i

    return ans


def get_lower_bound(row: list) -> int:

    st = 0
    ed = len(row)-1

    while (st <= ed):

        mid = (st + ed) >> 1

        if (row[mid] == 1):
            ed = mid - 1
        else:
            st = mid + 1

    return mid



# Since rows are sorted, so the row with maximum number of ones
# will the row the lowest lower bound of 1
# time compexity = O(nLog(m)), space complexity = O(1)
def get_row_with_max_ones(matrix: list[list]) -> int:
    rows: list = len(martix)
    ans = -1
    pos_ones = len(martix[0])

    for i in range(rows):

        if min(get_lower_bound(matrix[i]), pos_ones) < pos_ones:
            pos_ones = min(get_lower_bound(matrix[i]), pos_ones)
            ans = i

    return ans


if __name__ == "__main__":

    martix = [
        [0, 0, 0, 1, 1, 1],
        [0, 0, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0],
        [0, 0, 1, 1, 1, 1]
    ]
    print(get_row_with_max_ones(martix))
