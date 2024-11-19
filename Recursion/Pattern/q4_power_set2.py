from typing import List, Set


def helper(s: str, output: str, ans: Set[str]):
    if len(s) == 0:
        ans.add(output)
        return

    if len(s) > 0:
        output1 = output+s[0]
        helper(s[1:], output1, ans)

    helper(s[1:], output, ans)


def subsets(s: str) -> Set[str]:

    ans = set()
    output = ''
    helper(s, output, ans)
    return ans

def distinct_strings(s1: str, s2: str) -> str:
    s1_count = len(subsets(s1))
    s2_count = len(subsets(s2))
    
    return s1 if s1_count >= s2_count else s2_count


if __name__ == "__main__":

    s1 = input()
    s2 = input()
    print(distinct_strings(s1, s2))
