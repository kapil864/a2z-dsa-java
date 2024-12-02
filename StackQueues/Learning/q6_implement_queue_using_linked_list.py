class Node:

    def __init__(self, value, next=None):
        self.value = value
        self.next = next


class Queue:

    def __init__(self):
        self.head = None
        self._top = None

    def push(self, value):
        node = Node(value)
        if self.head is None:
            self.head = node
            self._top = node
            return

        self._top.next = node
        self._top = node

    def pop(self):

        if self.head is None:
            print('Queue is empty')
            return

        temp = self.head
        self.head = self.head.next
        return temp.value

    def top(self):

        if self.head is None:
            print('Queue is empty')

        return self.head.value


if __name__ == "__main__":
    queue = Queue()

    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)
    queue.push(5)
    queue.push(6)
    print(queue.pop())  # 1
    print(queue.top())  # 2
    print(queue.pop())  # 2
    print(queue.top())  # 3
    print(queue.pop())  # 3
    print(queue.top())  # 4
    print(queue.pop())  # 4
    print(queue.top())  # 5
