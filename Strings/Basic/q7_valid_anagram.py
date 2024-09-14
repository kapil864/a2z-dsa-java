
def isAnagram(s: str, t: str) -> bool:

    freq = {}
    for ch in s:
        if freq.get(ch) is None:
            freq[ch] = 1
            continue
        freq[ch] += 1
    
    for ch in t:
        if freq.get(ch) is None:
            return False
        elif freq.get(ch) < 1:
            return False
        freq[ch] -= 1
    for _,v in freq.items():
        if v >0:
            return False
    return True

if __name__ == "__main__":

    s = input()
    t = input()
    print(isAnagram(s, t))