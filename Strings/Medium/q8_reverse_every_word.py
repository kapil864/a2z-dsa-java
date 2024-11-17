def reverseWords(s: str) -> str:
    ans = ""
    temp = ""
    for ch in s:
        if ch != " ":
            temp += ch
        else:
            if temp != "":
                ans = temp+" "+ans
                temp = ""
    if temp != "":
        ans = temp+" "+ans
    return ans[:-1]

if __name__ == "__main__":
    string = input()
    print(reverseWords(string))

