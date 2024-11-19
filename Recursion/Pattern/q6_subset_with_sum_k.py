from typing import List


def helper(nums: List[int], output: int,  k: int):

    if output == k:
        return True

    if len(nums) == 0:
        return False
    return helper(nums[1:], output + nums[0], k) or helper(nums[1:], output, k)


def subsets_sum_k(nums: List[int], k: int) -> List[List[int]]:

    output = 0
    return helper(nums, output,  k)


if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    k = int(input())
    print(subsets_sum_k(nums, k))
