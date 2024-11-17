from q0_base import Node


class BrowserHistory:

    def __init__(self, homepage: str):
        self.curr = Node(data=homepage)

    def visit(self, url: str) -> None:
        node = Node(data=url)
        self.curr.next = node
        node.prev = self.curr
        self.curr = node

    def back(self, steps: int) -> str:
        while self.curr.prev and steps:
            self.curr = self.curr.prev
            steps -= 1
        return self.curr.data

    def forward(self, steps: int) -> str:
        while self.curr.next and steps:
            self.curr = self.curr.next
            steps -= 1
        return self.curr.data