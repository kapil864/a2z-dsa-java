from typing import List, Optional
from q0_base import Node, traversal, append


def findPairsWithGivenSum(target: int, head: Optional['Node']) -> List[List[int]]:
    if head.next is None:
        return []

    print(target)
    ptr1 = head
    ptr2 = head
    while ptr2 and ptr2.next:
        ptr2 = ptr2.next.next
        ptr1 = ptr1.next

    ptr2 = ptr1.prev
    ans = []
    print(ptr2.data)
    print(ptr1.data)

    while ptr1 and ptr2:
        pair_sum = ptr1.data + ptr1.data
        if pair_sum == target:
            ans.append([ptr2.data, ptr1.data])
            ptr2 = ptr2.prev
            ptr1 = ptr1.next
        elif pair_sum > target:
            ptr2 = ptr2.prev
        else:
            ptr1 = ptr1.next
    return ans


if __name__ == "__main__":

    numbers = list(map(int, input().split()))
    head = Node(numbers[0])
    for i in range(1, len(numbers)):
        append(head, Node(numbers[i]))
    traversal(head)
    x = int(input())
    pairs = findPairsWithGivenSum((x), head)
    print(pairs)
