
def is_palindorome(s):
    new_string = s[::-1]
    return new_string == s

# Brute force approach 
# TC = O(N^2)
# SC = O(N)
def longestPalindrome(s: str) -> str:

    ans = ""
    l = len(s)
    for i in range(l):
        string = ""
        for j in range(i, l):
            string += s[j]
            if is_palindorome(string):
                ans = string if len(string) > len(ans) else ans
    return ans


if __name__ == "__main__":
    string = input()
    print(longestPalindrome(string))
