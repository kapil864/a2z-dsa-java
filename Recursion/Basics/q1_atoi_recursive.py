def helper(s, ans):

    if len(s) == 1 or len(s) == 0:
        return

    ch = s[0]
    s = s[1:]

    ans = helper(s, ans)
    if ch == " " and len(ans) == 0:
        pass
    elif ch != ' ' and (ch in '+-' or ch in '0987654321') and len(s) == 0:
        ans = ch + ans
    elif ch != ' ' and ch in '0987654321':
        ans = ch + ans
    else:
        pass
    return ans


def myAtoi(s: str) -> int:
    nums = helper(s, '')
    if len(nums) == 0 or nums in '+-':
        return 0
    if int(nums) < - (2**31):
        return -2**31
    elif int(nums) > (2**31):
        return 2**31-1
    else:
        return int(nums)
    
if __name__ == "__main__":

    s = input()
    print(myAtoi(s))
