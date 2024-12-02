from typing import List
# in this approach the candidates cannot repeat themselves


# brute force approach
# use set to store answers, that will eliminate the duplicates
def helper_brute(index, target, candidates, candidate_combination, ans):
    if index < 0:
        return
    if target < 0:
        return
    if target == 0:
        ans.add(tuple(candidate_combination))
        return

    candidate_combination1 = candidate_combination.copy()
    candidate_combination1.append(candidates[index])
    helper(index-1, target-candidates[index],
           candidates, candidate_combination1, ans)
    helper(index-1, target, candidates, candidate_combination, ans)


def combinationSum_brute(candidates: List[int], target: int) -> List[List[int]]:

    ans = set()
    candidate_combination = []
    candidates.sort()

    helper_brute(len(candidates)-1, target, candidates,
                 candidate_combination, ans)
    return list(list(comb) for comb in ans)




def helper(index, target, candidate_combination, candidates, ans):
    if target == 0:
        ans.append(candidate_combination.copy())
        return
    
    if target < 0:
        return
    
    for i in range(index, len(candidates)):
        if i > index and candidates[i] == candidates[i-1]:
            continue
        if candidates[i] > target:
            break
        candidate_combination.append(candidates[i])
        helper(i+1, target-candidates[i], candidate_combination, candidates, ans)
        candidate_combination.pop()
    
# sort the candidates list,  this will make sure that duplicates are at fixed location
# we iterate over the candidates list if we find that, a recursion is already called for that index we don't call it again, same if that element is included in candidate_combination.
def combination_sum_optimal(candidates: List[int], target: int) -> List[List[int]]:

    ans = []
    candidates.sort()
    candidate_combination = []
    helper(0, target, candidate_combination, candidates, ans)
    return ans


if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    k = int(input())
    print(combination_sum_optimal(nums, k))
