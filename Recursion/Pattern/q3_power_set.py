from typing import List


def helper(nums: List[int], output: List[int], ans: List[List[int]]):
    if len(nums) == 0:
        ans.append(output)
        return

    if len(nums) > 0:
        output1 = output.copy()
        output1.append(nums[0])
        helper(nums[1:], output1, ans)

    helper(nums[1:], output, ans)


def subsets(nums: List[int]) -> List[List[int]]:

    ans = []
    output = []
    helper(nums, output, ans)
    return ans


if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    print(subsets(nums))
