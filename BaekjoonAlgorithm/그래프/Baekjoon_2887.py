# 특정 원소가 속한 집합을 찾기 
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
        return parent[x]
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

if __name__ == "__main__":
    n = int(input())
    parent = [0] * (n + 1) #부모 테이블 초기화

    #모든 간선을 담을 리스트와 최종 비용을 담을 변수
    edges = []
    result = 0
    x = []
    y = []
    z = []
    
    
    #부모 테이블상에서, 부모를 자기 자신으로 초기화
    for i in range(1, n + 1):
        parent[i] = i
    
    # 모든 노드에 대한 좌표 값 입력받기
    for i in range(1, n + 1):
        data = list(map(int, input().split()))
        x.append((data[0], i)) # x좌표값만 추가 -> i는 노드번호
        y.append((data[1], i)) # y좌표값만 추가
        z.append((data[2], i)) # z좌표값만 추가

    # 오름차순 정렬
    x.sort()
    y.sort()
    z.sort()
    
    for i in range(n - 1):
        # 비용순으로 정렬 위해서 첫 번째 원소를 비용으로 지정
        edges.append((x[i + 1][0] - x[i][0], x[i][1], x[i + 1][1]))
        edges.append((y[i + 1][0] - y[i][0], y[i][1], y[i + 1][1]))
        edges.append((z[i + 1][0] - z[i][0], z[i][1], z[i + 1][1]))

    # 여기서부터 코드를 수정해나가기
    edges.sort()
    

    for edge in edges:
        cost, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += cost
    print(result)
    
