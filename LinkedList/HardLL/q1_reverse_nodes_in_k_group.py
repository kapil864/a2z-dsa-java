from typing import Optional
from q0_base import ListNode, append, traversal


def reverse(head: ListNode):
    if head.next is None or head is None:
        return head

    temp = head.next
    reversed_list = reverse(head.next)
    temp.next = head
    head.next = None
    return reversed_list


def get_kth_node(temp: ListNode, k: int):
    while k > 1 and temp:
        temp = temp.next
        k -= 1
    return temp if k == 1 else None


def reverseKGroup(head: Optional[ListNode], k: int) -> Optional[ListNode]:
    previous_node = None
    next_node = None
    kth_node = None
    temp = head

    while temp:
        kth_node = get_kth_node(temp, k)
        if kth_node:
            next_node = kth_node.next
            kth_node.next = None
        else:
            previous_node.next = temp
            break
        reverse(temp)
        if temp == head:
            head = kth_node
        if previous_node:
            previous_node.next = kth_node
            previous_node = temp
        else:
            previous_node = temp
        temp = next_node

    return head


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    traversal(head)
    k = input()
    head = reverseKGroup(head, int(k))
    traversal(head)
