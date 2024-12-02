from collections import deque


class Stack:

    def __init__(self):
        self.stack = deque()

    def push(self, value):
        self.stack.append(value)
        return

    def pop(self):
        if len(self.stack) == 0:
            print('Stack empty')
        return self.stack.pop()

    def top(self):
        if len(self.stack) == 0:
            print('Stack empty')
        return self.stack[-1]
    

if __name__ == "__main__":

    stack = Stack()
    stack.push(1)
    stack.push(2)
    print(stack.stack)
    stack.push(3)
    print(stack.stack)
    stack.push(4)
    print(stack.stack)
    stack.push(5)
    print(stack.stack)
    stack.push(6)
    print(stack.stack)
    print(stack.pop())
    print(stack.stack)
    print(stack.pop())
    print(stack.stack)
    print(stack.pop())
    stack.push(7)
    print(stack.stack)
    print(stack.pop())
