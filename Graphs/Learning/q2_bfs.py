

from typing import List
from queue import Queue

def bfs(n, adjacency_list: List[List[int]]):

    ans = []
    queue = Queue()
    visited = [ 0 for _ in range(n+1)]
    visited[1] = 1
    queue.put(1)

    while not queue.empty():
        node  = queue.get()
        ans.append(node)
        for neighbor in adjacency_list[node]:
            if not visited[neighbor]:
                queue.put(neighbor)
                visited[neighbor] = 1
    
    return ans


if __name__ == "__main__":

    n = int(input())
    m = int(input())

    edges = []
    for i in range(m):
        edge = list(map(int, input().split(' ')))
        edges.append(edge)

    adjacency_list = [[] for _ in range(n+1)]
    for edge in edges:
        adjacency_list[edge[0]].append(edge[1])


    print(bfs(n, adjacency_list))
