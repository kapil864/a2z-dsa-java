def rotateString(s: str, goal: str) -> bool:
    s_len = len(s)
    goal_len = len(goal)
    if  s_len != goal_len:
        return False
    for i in range(s_len):
        temp_string = s[i:s_len]+s[:i]
        if temp_string == goal:
            return True
    return False



if __name__ == "__main__":

    s = input()
    t = input()
    print(rotateString(s, t))