
from typing import List


def helper(number, k, output, target, ans):
    if target == 0 and len(output) == k:
        ans.append(output.copy())
        return
    if len(output) > k:
        return
    if target < 0:
        return

    for i in range(number, 10):
        output.append(i)
        helper(i+1, k, output, target-i, ans)
        output.pop()


def combinationSum3(k: int, target: int) -> List[List[int]]:
    ans = []
    output = []
    helper(1, k, output, target, ans)
    return ans


if __name__ == "__main__":

    k = int(input())
    n = int(input())
    print(combinationSum3(k, n))
