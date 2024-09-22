from collections import Counter


def beautySum(s: str) -> int:
    
    def getSubBeauty(string):
        freq = Counter(string)
        min_value = 500
        max_value = 0
        for _,v in freq.items() :
            max_value = max(max_value, v)
            min_value = min (min_value, v)
        return max_value - min_value

    ans = 0
    l = len(s)
    for i in range(l):
        string = ""
        for j in range(i, l):
            string += s[j]
            ans += getSubBeauty(string)
    return ans


if __name__ == "__main__":
    string = input()
    print(beautySum(string))
