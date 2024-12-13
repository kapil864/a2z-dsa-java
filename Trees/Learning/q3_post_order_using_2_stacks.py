class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def post_order(root: Node):
    
    if not root :
        return []
    
    st1 = []
    st2 = []

    st1.append(root)
    while len(st1) > 0:

        top = st1.pop()
        if top.left:
            st1.append(top.left)
        if top.right:
            st1.append(top.right)
        
        st2.append(top.value)
    
    st2.reverse()
    return st2

if __name__ == "__main__":

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    print(post_order(root))