from typing import Optional
from q0_base import ListNode, append, traversal
# User function Template for python3

# brute force approach will be to traverse each and every node,
# store those in an array, sort that array
# crate a list from that array and return the newly formed list
'''

class Node:
    def __init__(self, d):
        self.data=d
        self.next=None
        self.bottom=None
        
'''


class Solution:
    def merge(self, list1, list2):

        dummy_head = Node(-1)
        temp = dummy_head
        while list1 and list2:
            if list1.data < list2.data:
                temp.bottom = list1
                temp = temp.bottom
                list1 = list1.bottom
            else:
                temp.bottom = list2
                temp = temp.bottom
                list2 = list2.bottom
            temp.next = None

        if list1:
            temp.bottom = list1
        if list2:
            temp.bottom = list2

        return dummy_head.bottom

    def flatten(self, head):
        if head is None or head.next is None:
            return head

        merged_head = self.flatten(head.next)
        return self.merge(head, merged_head)


# {
 # Driver Code Starts
# Initial Template for Python 3


class Node:

    def __init__(self, d):
        self.data = d
        self.next = None
        self.bottom = None


def printList(node):
    while (node is not None):
        print(node.data, end=" ")
        node = node.bottom

    print()


if __name__ == "__main__":
    t = int(input())
    while (t > 0):
        head = None
        arr = []

        arr = [int(x) for x in input().strip().split()]
        N = len(arr)
        temp = None
        tempB = None
        pre = None
        preB = None

        flag = 1
        flag1 = 1
        listo = [int(x) for x in input().strip().split()]
        it = 0
        for i in range(N):
            m = arr[i]
            m -= 1
            a1 = listo[it]
            it += 1
            temp = Node(a1)
            if flag == 1:
                head = temp
                pre = temp
                flag = 0
                flag1 = 1
            else:
                pre.next = temp
                pre = temp
                flag1 = 1

            for j in range(m):
                a = listo[it]
                it += 1
                tempB = Node(a)
                if flag1 == 1:
                    temp.bottom = tempB
                    preB = tempB
                    flag1 = 0
                else:
                    preB.bottom = tempB
                    preB = tempB
        ob = Solution()
        root = ob.flatten(head)
        printList(root)

        t -= 1
