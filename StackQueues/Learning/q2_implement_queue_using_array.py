class Queue:

    def __init__(self, size):
        self.size = size
        self.array = [0]*size
        self.start = -1
        self.end = -1
        self.currentSize = 0

    def push(self, value):

        if self.currentSize == self.size:
            print('Queue full')
            return

        if self.currentSize == 0:
            self.start += 1

        self.end = (self.end + 1) % self.size
        self.array[self.end] = value
        self.currentSize += 1

    def pop(self):

        if self.currentSize == 0:
            print('Queue empty')
            return

        temp = self.array[self.start]
        self.array[self.start] = 0
        self.start = (self.start + 1) % self.size

        self.currentSize -= 1

        if self.currentSize == 0:
            self.start = self.end = -1
        return temp

    def top(self):
        if self.currentSize > 0:
            return self.array[self.start]
        print('Queue empty')

if __name__ == "__main__":

    queue = Queue(3)

    print(queue.array)
    queue.push(1)
    print(queue.array)
    queue.push(2)
    print(queue.array)
    queue.push(3)
    print(queue.array)
    queue.push(4)
    print(queue.array)
    print(queue.pop())
    print(queue.pop())
    queue.push(5)
    print(queue.array)
    print(queue.pop())
    queue.push(6)
    print(queue.array)
    print(queue.pop())
    print(queue.pop())
    print(queue.pop())
    print(queue.pop())