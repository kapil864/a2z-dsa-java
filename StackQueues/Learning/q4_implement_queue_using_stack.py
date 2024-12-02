class Queue:

    def __init__(self):
        self.queue = []

    def push(self, value):

        if len(self.queue) == 0:
            self.queue.append(value)
            return

        element = self.queue.pop()
        self.push(value)
        self.queue.append(element)

    def pop(self):
        if len(self.queue) == 0:
            print("Stack empty")
            return
        return self.queue.pop()

    def top(self):
        if len(self.queue) == 0:
            print("Stack empty")
            return
        return self.queue[-1]
    

if __name__ == "__main__":
    queue = Queue()

    queue.push(1)
    print(queue.queue)
    queue.push(2)
    print(queue.queue)
    queue.push(3)
    print(queue.queue)
    queue.push(4)
    print(queue.queue)
    queue.push(5)
    print(queue.queue)
    queue.push(6)
    print(queue.queue)
    print(queue.pop()) # 1
    print(queue.top()) # 2
    print(queue.pop()) # 2
    print(queue.top()) # 3
    print(queue.pop()) # 3
    print(queue.top()) # 4
    print(queue.pop()) # 4
    print(queue.top()) # 5