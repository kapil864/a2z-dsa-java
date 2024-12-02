
def helper(nums, index, total, ans):
    if index == len(nums):
        ans.append(total)
        return
    
    # include the element
    helper(nums, index+1, total+ nums[index], ans)
    # do not the element
    helper(nums, index+1, total, ans)


def subset_sum(nums : list):
    ans = []
    helper(nums, 0, 0, ans)
    ans.sort()
    return ans

if __name__ == "__main__":

    nums = list(map(int, input().split(' ')))
    print(subset_sum(nums))