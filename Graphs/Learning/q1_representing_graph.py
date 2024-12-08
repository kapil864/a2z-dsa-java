# in input no of nodes and no of edges will be given
# n nodes and m edges

# for undirected graphs
# u v , i.e there is an edge between u - v and v - u

# for directed graphs
# u v, i.e there is an edge between u and v

# undirected graphs
def store_in_adjacency_matrix_undirected(m, n, edges):
    matrix = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for edge in edges:
        matrix[edge[0]][edge[1]] = 1
        matrix[edge[1]][edge[0]] = 1
    return matrix


def store_in_adjacency_list_undirected(n, m, edges):
    adjacency_list = [[] for _ in range(n+1)]
    for edge in edges:
        adjacency_list[edge[0]].append(edge[1])
        adjacency_list[edge[1]].append(edge[0])
    return adjacency_list


# directed graphs
def store_in_adjacency_matrix_directed(m, n, edges):
    matrix = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for edge in edges:
        matrix[edge[0]][edge[1]] = 1
    return matrix


def store_in_adjacency_list_directed(n, m, edges):
    adjacency_list = [[] for _ in range(n+1)]
    for edge in edges:
        adjacency_list[edge[0]].append(edge[1])
    return adjacency_list


# undirected weighted graphs
def store_in_adjacency_matrix_weighted_undirected(m, n, edges):
    matrix = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for edge in edges:
        matrix[edge[0]][edge[1]] = edge[2]
        matrix[edge[1]][edge[0]] = edge[2]
    return matrix


def store_in_adjacency_list_weighted_undirected(n, m, edges):
    adjacency_list = [[] for _ in range(n+1)]
    for edge in edges:
        adjacency_list[edge[0]].append([edge[1], edge[2]])
        adjacency_list[edge[1]].append([edge[0], edge[2]])
    return adjacency_list


# weighted directed graphs
def store_in_adjacency_matrix_weighted_directed(m, n, edges):
    matrix = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for edge in edges:
        matrix[edge[0]][edge[1]] = edge[2]
    return matrix


def store_in_adjacency_list_weighted_directed(n, m, edges):
    adjacency_list = [[] for _ in range(n+1)]
    for edge in edges:
        adjacency_list[edge[0]].append([edge[1], edge[2]])
    return adjacency_list


if __name__ == "__main__":
    n = int(input())
    m = int(input())

    edges = []
    for i in range(m):
        edge = list(map(int, input().split(' ')))
        edges.append(edge)

    graph_matrix = store_in_adjacency_matrix_undirected(m, n, edges)
    # print(graph_matrix)

    adjacency_list = store_in_adjacency_list_undirected(n, m, edges)
    print(adjacency_list)
