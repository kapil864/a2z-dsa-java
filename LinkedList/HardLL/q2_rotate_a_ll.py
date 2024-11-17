from typing import Optional

from LinkedList.HardLL.q0_base import ListNode


class Solution:
    def len_ll(self, head: ListNode):
        x = 0
        while head:
            head = head.next
            x += 1
        return x

    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        l = self.len_ll(head)
        temp = head
        n = 1
        k = k % l
        if k == 0:
            return head

        while n != l - k:
            temp = temp.next
            n += 1

        new_head = temp.next
        temp.next = None
        temp = new_head
        while temp.next:
            temp = temp.next

        temp.next = head
        return new_head
