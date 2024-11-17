class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def append(head:ListNode, node : ListNode):
    
    if head == None:
        return node
    
    temp = head
    while temp.next:
        temp =temp.next
    
    temp.next = node

def traversal(head):
    temp = head 
    while temp.next:
        print(temp.val, end='->')
        temp = temp.next
    print(temp.val)
    

     
def deleteNode(node : ListNode):
    while node.next.next:
            node.val = node.next.val
            node = node.next
        
    node.val = node.next.val
    node.next = None