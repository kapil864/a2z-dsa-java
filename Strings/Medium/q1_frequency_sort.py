def frequencySort(s: str) -> str:

    freq = {}
    ans = ""
    for ch in s:
        if freq.get(ch) is None:
            freq[ch] = 1
            continue
        freq[ch] += 1
    
    values = sorted(list(freq.items()),key=lambda x: x[1], reverse=True)
    for ch, count in values:
        ans = ans+ (ch*count)

    return ans


if __name__ == "__main__":
    string = input()
    print(frequencySort(string))