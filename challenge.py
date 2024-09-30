class CustomStack:

    def __init__(self, maxSize: int):
        self.maxSize = maxSize
        self.size = 0
        self.l = []

    def push(self, x: int) -> None:
        if self.size < self.maxSize:
            self.l.append(x)
            self.size += 1

    def pop(self) -> int:
        if self.size > 0:
            self.size -= 1
            return self.l.pop()
        return -1

    def increment(self, k: int, val: int) -> None:
        for i in range (min(k, self.size)):
            self.l[i] += 100

stk = CustomStack(3)
print(stk.push(1))
print(stk.push(2))
print(stk.pop())
print(stk.push(2))
print(stk.push(3))
print(stk.push(4))
print(stk.increment(5, 100))
print(stk.increment(2, 100))
print(stk.pop())
print(stk.pop())
print(stk.pop())
print(stk.pop())


print(stk.l)