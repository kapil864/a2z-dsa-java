from typing import Optional
from q0_base import ListNode, append, traversal

def detectCycle(head: Optional[ListNode]) -> Optional[ListNode]:
    slow = head 
    fast = head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if fast == slow:
            break
    else: 
        return None
    
    slow = head
    while slow != fast:
        slow = slow.next
        fast= fast.next

    return slow