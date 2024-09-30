from typing import Optional
from q0_base import ListNode, append, traversal

def countNodesInLoopBrute(head:ListNode):
    node_set = set()
    temp = head
    length = 0
    while temp:
        if temp in node_set:
            curr = temp
            while True:
                curr= curr.next
                length += 1

                if curr == temp:
                    return length

        node_set.add(temp)
        temp = temp.next
    return length



def len_loop(head: ListNode) -> int:
    temp = head
    length = 0
    while True:
        temp = temp.next
        length += 1
        if temp == head:
            return length
    return length

def countNodesInLoop(head:ListNode):
    slow = head
    fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

        if slow == fast:
            return len_loop(slow)
    return 0