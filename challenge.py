from heapq import heapify
from typing import List
from collections import Counter
from functools import cmp_to_key


def findXSum(nums: List[int], k: int, x: int) -> List[int]: 
    def custom_sort(a , b):
        if a[1] > b[1]:
            return -1
        elif a[1] == b[1]:
            if a[0] > b[0]:
                return -1
            else:
                return 1
        else:
            return 1
        
    l = len(nums)
    ans = []
    for i in range(l - k + 1):
        freq_arr = {}
        for j in range(i,k+i):
            if not freq_arr.get(nums[j]):
                freq_arr[nums[j]] = 1
            else:
                freq_arr[nums[j]] += 1
        freq_arr = sorted(list(freq_arr.items()), key=cmp_to_key(custom_sort))
        sub_arr_sum = 0
        for j in range(min(x,len(freq_arr))):
            sub_arr_sum += (freq_arr[j][0]*freq_arr[j][1])
        ans.append(sub_arr_sum)
    return ans


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    print(findXSum([3,8,7,8,7,5],2,2))
