from heapq import heapify
from typing import List


def arrayRankTransform(arr: List[int]) -> List[int]:
    temp = []
    for i in range(len(arr)):
        temp.append([arr[i], i])
    temp.sort()
    
    rank = 1
    for i in range(len(temp)):
        if i < len(temp)-1 and temp[i+1][0] != temp[i][0]:
            rank += 1
        arr[temp[i][1]] = rank
    return arr
if __name__ == "__main__":
    print(arrayRankTransform([40,10,20,30]))
