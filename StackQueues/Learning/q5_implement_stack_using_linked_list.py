class Node:
    def __init__(self, value, next = None):
        self.value = value
        self.next = next


class Stack:

    def __init__(self):
        self._top = None
        self.head = None
    

    def push(self, value):
        if self.head is None:
            self.head = Node(value)
            self._top = self.head
            return
        
        node = Node(value)
        self._top.next = node
        self._top = node
    
    def pop(self):

        if self._top is None:
            print('Stack Empty')
            return
        
        temp = self.head
        while temp.next and temp.next != self._top:
            temp = temp.next
        
        deleted_node = temp.next
        temp.next = None
        self._top = temp
        return deleted_node.value
    
    def top(self):
        return self._top.value
    
if __name__ == "__main__":
    queue = Stack()

    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)
    queue.push(5)
    queue.push(6)
    print(queue.pop()) # 1
    print(queue.top()) # 2
    print(queue.pop()) # 2
    print(queue.top()) # 3
    print(queue.pop()) # 3
    print(queue.top()) # 4
    print(queue.pop()) # 4
    print(queue.top()) # 5