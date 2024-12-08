
from typing import List

def dfs(node, visited, ans, adjacency_list):
    visited[node] = 1
    ans.append(node)

    for adjacent_node in adjacency_list[node]:
        if not visited[adjacent_node]:
            dfs(adjacent_node, visited, ans, adjacency_list)

def bfs_graph(adjacency_list: List[List[int]]):
    visited = [0 for _ in range(len(adjacency_list)+1)]
    visited[1] = 1
    ans = []
    dfs(1, visited, ans, adjacency_list)
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

    print(bfs_graph(adjacency_list))