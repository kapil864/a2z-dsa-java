from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def modifiedList(nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:

    number_set = set(nums)

    while head.val in number_set:
        head = head.next

    node = head

    while node.next is not None and node is not None:

        if node.next.val in number_set:
            node.next = node.next.next
        else:
            node = node.next

    return head
