def romanToInt(s: str) -> int:
    roman = {
        "I":  1,
        "V":  5,
        "X":  10,
        "L":  50,
        "C":  100,
        "D":  500,
        "M":  1000
    }

    no = 0
    l = len(s)
    for i in range(l):
        if i < l-1 and s[i] == "I" and(s[i+1] == "V" or s[i+1] == "X") :
            no -= roman[s[i]]
        elif i < l-1 and s[i] == "X" and (s[i+1] == "L" or s[i+1] == "C"):
            no -= roman[s[i]]
        elif i < l-1 and s[i] == "C" and (s[i+1] == "D" or s[i+1] == "M"):
            no -= roman[s[i]]
        else:
            no += roman[s[i]]
    return no

if __name__ == "__main__":
    string = input()
    print(romanToInt(string))
