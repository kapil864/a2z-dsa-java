from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# modify height of a binary tree function to find the ans
def height(root:  Optional[TreeNode]):
    if root == None:
        return 0

    lh = height(root.left)
    if lh == -1:
        return -1
    rh = height(root.right)
    if rh == -1:
        return -1

    if abs(lh - rh) > 1:
        return -1

    return max(lh, rh) + 1


def isBalanced(root: Optional[TreeNode]) -> bool:
    return height(root) != -1


if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)

    print(isBalanced(root))
