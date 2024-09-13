from typing import List


def findPeakGrid( mat: List[List[int]]) -> List[int]:
        m = len(mat) -1
        n = len(mat[0]) -1

        st = 0
        ed = m
        
        def getMaxCol (mat, row):
            mx_no = 0
            nonlocal n
            for i in range(n+1):
                if mat[row][i] > mat[row][mx_no]:
                    mx_no = i
            return mx_no


        while st <= ed:
            mid = (st+ed)>>1
            col = getMaxCol(mat, mid)

            top = mat[mid-1][col] if mid > 0 else -1
            bottom = mat[mid+1][col] if mid < m else -1

            if mat[mid][col] > top and mat[mid][col] > bottom:
                return [mid, col]
            elif mat[mid][col] < top:
                ed = mid -1
            else:
                st = mid +1

        return [-1, -1]


if __name__ == "__main__":
    m = int(input())
    n = int(input())

    matrix = []
    for i in range(m):
        numbers = list(map(int,input().split(" ")))
        matrix.append(numbers)
    
    print(findPeakGrid(matrix))