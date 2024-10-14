from typing import Optional
from q0_base import ListNode, append, traversal


def getIntersectionNodeBrute(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
    node_set = set()
    while headA:
        node_set.add(headA)
        headA = headA.next

    while headB:
        if headB in node_set:
            return headB
        headB = headB.next
    return None


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def collision_point(self, headA, headB, k):

        while k != 0:
            headB = headB.next
            k -= 1

        while headA and headB:
            if headA == headB:
                break
            headB = headB.next
            headA = headA.next

        return headA

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        tempA = headA
        tempB = headB
        n1 = 0
        n2 = 0
        while tempA and tempB:
            tempA = tempA.next
            tempB = tempB.next
            n1 += 1
            n2 += 1

        while tempA:
            tempA = tempA.next
            n1 += 1

        while tempB:
            tempB = tempB.next
            n2 += 1

        if n1 < n2:
            return self.collision_point(headA, headB, n2 - n1)
        else:
            return self.collision_point(headB, headA, n1 - n2)
