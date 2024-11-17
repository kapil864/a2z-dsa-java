def put_at_last(stack: list, element: int):

    if len(stack) == 0:
        stack.append(element)
        return

    top = stack.pop()
    put_at_last(stack, element)
    stack.append(top)


def reverse_stack(stack: list):

    if len(stack) == 0 or len(stack) == 1:
        return

    top_elem = stack.pop()
    reverse_stack(stack)
    put_at_last(stack, top_elem)


if __name__ == "__main__":
    stack = list(map(int, input().split(' ')))
    reverse_stack(stack)
    print(stack)
