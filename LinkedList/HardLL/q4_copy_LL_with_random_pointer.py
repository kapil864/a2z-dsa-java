class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


def traverse(list_head: Node):
    head = list_head
    while head.next:
        print(f"{head.val}->", end='')
        head = head.next
    print(head.val)
    head = list_head
    while head.next:
        print(f"{head.random.val if head.random else 0}->", end='')
        head = head.next
    print(head.random.val if head.random else 0)


def copy_using_map(head: Node):

    temp = head
    node_map = {}
    new_list_head = Node(-1)
    new_list_temp = new_list_head

    while temp:
        node = Node(temp.val)
        new_list_temp.next = node
        new_list_temp = node
        node_map[temp] = node
        temp = temp.next

    temp = head
    while temp:
        random = temp.random
        d_node = node_map[temp]
        if random:
            d_node.random = node_map[random]
        else:
            d_node.random = None
        temp = temp.next

    return new_list_head.next

# involves 3 steps
# Create duplicate node and insert it between original nodes
# point random pointer to correct nodes in copy nodes
# remove link between copy nodes and original nodes
def copy_without_map(head: Node):
    
    o_temp = head
    # insert duplicate nodes
    while o_temp:
        c_node = Node(o_temp.val)
        c_node.next = o_temp.next
        o_temp.next = c_node
        o_temp = c_node.next
    
    # point random to correct copy node
    c_head = head.next
    c_temp = c_head
    o_temp = head

    while o_temp:
        c_temp.random = o_temp.random.next if o_temp.random else None
        c_temp = c_temp.next.next if c_temp.next else None
        o_temp = o_temp.next.next

    # fix links between nodes
    c_temp = head.next
    o_temp = head

    while c_temp:
        o_temp.next = c_temp.next
        o_temp = o_temp.next
        c_temp.next = o_temp.next if o_temp else None
        c_temp = c_temp.next
    
    return c_head

if __name__ == "__main__":

    n1 = Node(1)
    n2 = Node(2)
    n1.next = n2
    n3 = Node(3)
    n2.next = n3
    n4 = Node(4)
    n3.next = n4
    n5 = Node(5)
    n4.next = n5
    n6 = Node(6)
    n5.next = n6
    n7 = Node(7)
    n6.next = n7

    n1.random = None
    n2.random = n5
    n3.random = n2
    n4.random = n7
    n5.random = n1
    n6.random = n1
    n7.random = n4

    head = n1
    traverse(n1)
    print()
    traverse(copy_without_map(head))
