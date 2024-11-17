class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def append(head: ListNode, node: ListNode):

    if head == None:
        return node

    while head.next:
        head = head.next

    head.next = node


def traversal(head: ListNode):
    while head.next:
        print(head.val, end='->')
        head = head.next
    print(head.val)

