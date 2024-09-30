from q0_base import ListNode, append, traversal

# find the lenght of linked list
# the traverse the ll to lenght/2, and return that node


def middle_brute():
    pass

# tortose hare//
# we take two pointes
# and for every one update to a pointer we update second one with double
# ultimalty first pointer will point to mid
def middle(head):
    ptr1 = head
    while head and head.next:

        head = head.next.next
        ptr1 = ptr1.next

    return ptr1.val


if __name__ == "__main__":
    numbers = list(map(int, input().split()))
    head = ListNode(numbers[0])
    for j in range(1, len(numbers)):
        append(head, ListNode(numbers[j]))
    traversal(head)

    print(middle(head))
