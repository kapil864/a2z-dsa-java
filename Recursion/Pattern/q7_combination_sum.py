from typing import List, Set


def helper(index, target, candidates, candidate_combination, ans):
    if index < 0:
        return
    if target == 0:
        ans.append(candidate_combination)
        return

    if target < 0:
        return
    candidate_combination1 = candidate_combination.copy()
    candidate_combination1.append(candidates[index])
    helper(index, target-candidates[index],
           candidates, candidate_combination1, ans)
    helper(index-1, target, candidates, candidate_combination, ans)


def combinationSum(candidates: List[int], target: int) -> List[List[int]]:

    ans = []
    candidate_combination = []

    helper(len(candidates)-1, target, candidates, candidate_combination, ans)
    return ans


if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    k = int(input())
    print(combinationSum(nums, k))
