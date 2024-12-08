from typing import List
from queue import Queue


def orangesRotting(grid: List[List[int]]) -> int:
    if grid == None or len(grid) == 0:
        return 0

    n = len(grid)
    m = len(grid[0])

    queue = Queue()

    # put rotten oranges in queue
    fresh_oranges = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 2:
                queue.put([i, j, 0])
            elif grid[i][j] == 1:
                fresh_oranges += 1
    
    if fresh_oranges == 0:
        return 0

    time_to_rot = 0
    # do a bfs for the oranges
    oranges_put_in_queue = 0

    drow = [0, 0, 1, -1]
    dcol = [1, -1, 0, 0]
    while not queue.empty():
        rotton_orange = queue.get()
        r = rotton_orange[0]
        c = rotton_orange[1]
        t = rotton_orange[2]
        # print([r,c])

        time_to_rot = max(time_to_rot, t)

        for i in range(4):
            nrow = r + drow[i]
            ncol = c + dcol[i]

            # insert fresh oranges in queue
            if nrow < n and nrow >= 0 and ncol < m and ncol >= 0 and grid[nrow][ncol] == 1:
                queue.put([nrow, ncol, t+1])
                oranges_put_in_queue += 1
                grid[nrow][ncol] = 2

    # check if any fresh oranges are left or not
    if fresh_oranges != oranges_put_in_queue:
        return -1

    return time_to_rot


if __name__ == "__main__":

    m = int(input())
    n = int(input())

    oranges = []
    for i in range(m):
        row = list(map(int, input().split(' ')))
        oranges.append(row)
    print(orangesRotting(oranges))
