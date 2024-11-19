from typing import List

def helper(nums: List[int], output: List[int], ans: List[List[int]], k : int):
    
    if sum(output) == k:
        ans.append(output)
        return

    if len(nums) == 0:
        return

    if len(nums) > 0:
        output1 = output.copy()
        output1.append(nums[0])
        helper(nums[1:], output1, ans, k)

    helper(nums[1:], output, ans, k)


def subsets_sum_k(nums: List[int], k : int) -> List[List[int]]:

    ans = []
    output = []
    helper(nums, output, ans, k)
    return ans



if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    k = int(input())
    print(subsets_sum_k(nums, k))