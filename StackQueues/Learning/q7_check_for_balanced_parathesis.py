def isValid(s: str) -> bool:
    stack = []
    for ch in s:
        if ch in '([{':
            stack.append(ch)

        if ch == ')':
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            else:
                return False

        if ch == ']':
            if len(stack) > 0 and stack[-1] == '[':
                stack.pop()
            else:
                return False

        if ch == '}':
            if len(stack) > 0 and stack[-1] == '{':
                stack.pop()
            else:
                return False

    if len(stack) > 0:
        return False
    return True

if __name__ == "__main__":
    s = input()
    print(isValid(s))
