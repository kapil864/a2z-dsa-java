from typing import List, Optional
from q0_base import Node, traversal, append


def removeDuplicates(head: Node) -> Node:
    temp = head
    while temp:
        next_node = temp.next
        while next_node and next_node.data == temp.data:
            next_node = next_node.next
        temp.next = next_node
        if next_node:
            next_node.prev = temp
        temp = next_node
    return head


if __name__ == "__main__":

    numbers = list(map(int, input().split()))
    head = Node(numbers[0])
    for i in range(1, len(numbers)):
        append(head, Node(numbers[i]))
    head = removeDuplicates(head)
    traversal(head)
