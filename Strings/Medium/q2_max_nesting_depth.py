def maxDepth(s: str) -> int:
    balance = 0
    ans = 0
    for ch in s :
        match ch:
            case "(":
                balance += 1
                ans = max(ans, balance)
            case ")":
                balance -= 1
    return ans



if __name__ == "__main__":
    string = input()
    print(maxDepth(string))
