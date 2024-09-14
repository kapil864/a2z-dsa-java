from typing import List


def longestCommonPrefix(strs: List[str]) -> str:
    prefix = strs[0]
    for word in strs:
        temp_pre = ""
        for i in range(min(len(prefix),len(word))):
            if word[i] == prefix[i]:
                temp_pre += word[i]
            else:
                break
        prefix = temp_pre
    return prefix

if __name__ == "__main__":

    string = input().split()
    print(longestCommonPrefix(string))