from typing import Optional
from q0_base import ListNode, append, traversal

# store node in set if node is visidted again then it's a loop


def hasCycleBrute(head: Optional[ListNode]) -> bool:
    node_set = set()
    while head:
        node_set.add(head)
        if head in node_set:
            return True
        head = head.next
    return False

# tortoise hare algorihtim
def hasCycle(head: Optional[ListNode]) -> bool:
    slow = head
    fast = head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if fast == slow:
            return True
    return False


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    head = hasCycleBrute(head)
    traversal(head)
