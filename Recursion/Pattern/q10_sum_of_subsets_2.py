# print all unique subsets

from typing import List

# using sets


def helperBrute(nums, index, output, ans):
    if index == len(nums):
        ans.add(tuple(output))
        return

    helperBrute(nums, index+1, output, ans)
    output2 = output.copy()
    output2.append(nums[index])
    helperBrute(nums, index+1, output2, ans)


def subsetsWithDupBrute(nums: List[int]) -> List[List[int]]:
    ans = set()
    output = []
    helperBrute(nums, 0, output, ans)
    return [list(com) for com in ans]

# optimal sets
def helper(nums, index, output, ans):
    ans.append(output.copy())
    for i in range(index, len(nums)):
        if i > index and nums[i] == nums[i-1]:
            continue
        output.append(nums[i])
        helper(nums, i +1, output, ans)
        output.pop()

def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    ans = []
    output = []
    nums = sorted(nums)
    helper(nums, 0, output, ans)
    return ans

if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    print(subsetsWithDup(nums))
