
class Stack:

    def __init__(self, size):
        self.top = -1
        self.array = [0]*size
        self.size = size

    def push(self, value):
        if self.top < self.size-1:
            self.top += 1
            self.array[self.top] = value
            return
        raise IndexError('Stack is full')

    def pop(self):

        if self.top > -1:
            temp =  self.array[self.top]
            self.array[self.top] = 0
            self.top -= 1
            return temp
        raise ValueError('Stack empty')

    def top(self):

        if self.top > 0:
            return self.array[self.top]
        raise ValueError('Stack empty.')

    def size(self):
        return self.top + 1


if __name__ == "__main__":

    stack = Stack(3)
    stack.push(1)
    print(stack.array)
    stack.push(2)
    print(stack.array)
    stack.push(3)
    print(stack.array)
    print(stack.pop())
    print(stack.array)