class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


def traversal(head: Node):
    while head.next:
        print(head.data, end='<->')
        head = head.next

    print(head.data)


def append(head: Node, node: Node):
    if not head:
        return node

    temp = head
    while temp.next:
        temp = temp.next

    temp.next = node
    node.prev = temp.next
    return head


if __name__ == "__main__":

    numbers = list(map(int, input().split(' ')))
    head = Node(numbers[0])
    for i in range(1, len(numbers)):
        append(head, Node(numbers[i]))
    traversl(head)
