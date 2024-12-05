
from typing import List

# brute force:-
# Generate all subsequences and check that if it is a palindrome
# if it is a palindrome, then it is a answer
# but this won't show partitions



def isPalindrome(s, st, ed):
    while st < ed:
        if s[st] != s[ed]:
            return False
        st += 1
        ed -= 1
    return True


def helper(s, index, ds, ans):
    
    if index == len(s):
        ans.append(ds.copy())
        return
    
    for i in range(index, len(s)):
        if isPalindrome(s, index, i):
            ds.append(s[index:i+1])
            helper(s, i+1, ds, ans)
            ds.pop()
        else:
            continue
    


def partition(s: str) -> List[List[str]]:
    ans = []
    ds = []
    helper(s, 0, ds, ans)
    return ans


if __name__ == "__main__":

    s = input()
    print(partition(s))
