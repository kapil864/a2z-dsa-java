


from typing import List

def dfs(node, visited, adjacency_list):
    visited[node] = 1
    for adjacent in adjacency_list[node]:
        if not visited[adjacent]:
            dfs(adjacent, visited, adjacency_list)

def findCircleNum(isConnected: List[List[int]]) -> int:
    
    adjacency_list = [ [] for _ in range(len(isConnected))]
    for i in range(len(isConnected)):
        for j in range(len(isConnected)):
            if isConnected[i][j] == 1 and i != j:
                adjacency_list[i].append(j)
                adjacency_list[j].append(i)

    visited = [ 0 for _ in range(len(isConnected))]
    provinces = 0
    for i in range(len(isConnected)):
        if not visited[i]:
            provinces += 1
            dfs(i, visited, adjacency_list)
            
    return provinces



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

    print(findCircleNum([[1,0,0],[0,1,0],[0,0,1]]))