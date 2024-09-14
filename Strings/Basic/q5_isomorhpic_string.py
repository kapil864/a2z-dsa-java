def isIsomorphic(s: str, t: str) -> bool:

    string_map = {}
    n = len(s)
    for i in range(n):
        if string_map.get(s[i]) == None:
            if t[i] in string_map.values():
                return False
            string_map[s[i]] = t[i]
        elif string_map.get(s[i]) != t[i]:
            return False
    return True


if __name__ == "__main__":

    s = input()
    t = input()
    print(isIsomorphic(s, t))
