def place_at_pos(stack: list, elem: int):

    if len(stack) >= 0 and stack[-1] <= elem:
        stack.append(elem)
        return

    top_elem = stack.pop()
    place_at_pos(stack, elem)
    stack.append(top_elem)


def sort_stack(stack: list):

    if len(stack) == 0 or len(stack) == 1:
        return

    elem = stack.pop()
    sort_stack(stack)
    place_at_pos(stack, elem)


if __name__ == "__main__":
    stack = list(map(int, input().split(' ')))
    sort_stack(stack)
    print(stack)
