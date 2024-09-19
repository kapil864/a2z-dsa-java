
# brute force
# check for all possible substrings and count number of unuique characters in that substring
# TC = (O^2)
def substrCountBrute(s, k):
    l = len(s)
    ans = 0
    for i in range(l):
        char_set = set()
        for j in range(i, l):
            char_set.add(s[j])

            if len(char_set) == k:
                ans += 1
            elif len(char_set) > k:
                break
    return ans

if __name__ == "__main__":
    string = input()
    k = int(input())
    print(substrCountBrute(string, k))
