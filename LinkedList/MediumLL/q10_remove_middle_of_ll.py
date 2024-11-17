from typing import Optional
from q0_base import ListNode, append, traversal


def deleteMiddle(head: Optional[ListNode]) -> Optional[ListNode]:
    if head.next.next is None:
        head.next = None
        return head

    slow = head
    fast = head.next.next

    while fast and fast.next:

        slow = slow.next
        fast  = fast.next.next
    
    temp = slow.next
    slow.next = temp.next
    del temp
    return head


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    head = deleteMiddle(head)
    traversal(head)