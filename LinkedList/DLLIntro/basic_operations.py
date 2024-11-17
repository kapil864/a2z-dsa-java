class Node:

    def __init__(self, val) -> None:
        self.val = val
        self.previous = None
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
    node.previous = temp


def insert_after_pos(head: Node, pos: int, node: Node):
    """
    `head` : head of doubly list
    `pos` : postion after which to insert node, 0 based
    `node` : DLL node to insert
    """
    temp = head

    while pos > 0 and temp.next:
        temp = temp.next
        pos -= 1

    if temp.next:
        node.next = temp.next
        temp.next = node
        node.previous = temp
        node.next.previous = node
    else:
        temp.next = node
        node.previous = temp


def delete_at_pos(head:Node, pos):
    

    if pos == 1:
        head = head.next
        head.previous = None
        return head
    
    temp = head
    while pos > 1 and temp.next:
        temp= temp.next
        pos -= 1
    
    if temp.next :
        temp.previous.next = temp.next
        temp.next.previous = temp.previous
    else:
        temp.previous.next = None
    return head

if __name__ == "__main__":

    head = Node(2)
    append(head, Node(4))
    append(head, Node(5))
    append(head, Node(3))
    append(head, Node(34))
    append(head, Node(89))
    append(head, Node(12))
    traversal(head)

    insert_after_pos(head, 0, Node(6))
    traversal(head)
    head = delete_at_pos(head, 2)
    traversal(head)
