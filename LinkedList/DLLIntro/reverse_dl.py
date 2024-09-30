class Node:

    def __init__(self, val) -> None:
        self.val = val
        self.prev = None
        self.next = None


def traversal(head: Node):
    temp = head
    while temp.next:
        print(temp.val, end="<->")
        temp = temp.next
    print(temp.val)


def append(head: Node, node: Node):
    temp = head
    while temp.next:
        temp = temp.next

    temp.next = node
    node.prev = temp

# similar to swapping two numbers


def reverse(head):
    if head.next is None:
        return head
    while head:
        last = head.prev
        head.prev = head.next
        head.next = last
        head = head.prev

    return last.prev


if __name__ == "__main__":

    head = Node(2)
    append(head, Node(4))
    append(head, Node(5))
    append(head, Node(3))
    append(head, Node(34))
    append(head, Node(89))
    append(head, Node(12))
    traversal(head)
    head = reverse(head)
    traversal(head)
