from collections import deque
t = int(input())
for _ in range(t):
    n = int(input()) # 전체 팀 수
    indegree = [0] * (n + 1) # 진입 차수 표 만들기
    graph = [[] for i in range(n + 1)]
    data = list(map(int, input().split())) # 팀의 정보가 담김
    #왼쪽부터 일등이고 자기보다 아랫 등수를 다 가리키는 구조
    for i in range(1, n + 1): # 진입차수가 많으면 꼴지인 것
        indegree[data[i - 1]] += i - 1 # 그걸 바탕으로 진입차수 테이블을 업데이트     

    # 그래프 만들기 
    for i in range(1, n + 1): #팀의 왼쪽부터 순서대로 가리킨다.
        for j in range(i, n):
            graph[data[i - 1]].append(data[j])      
           
        
    #가장 왼쪽부터 1등, 2등...
    m = int(input()) 
    for _ in range(m): # 순위 변동을 바탕으로 그래프를 업데이트
        a, b = map(int, input().split())
        #그래프도 바꾸기, 들어오는 것을 추가, 나가는 것은 제거
        if b in graph[a]: #만약 a가 b를 가리킨다면 바꾸기
            graph[a].remove(b)
            graph[b].append(a)
            indegree[a] += 1
            indegree[b] -= 1
        else:
            graph[b].remove(a)
            graph[a].append(b)
            indegree[b] += 1
            indegree[a] -= 1

    #이제 위상정렬을 수행 -> 확실한 수행을 찾을 수 없다는 것은 위상정렬이 경우가 여러 개인 경우이고, 정렬 불가능하다는 것은 사이클이 발생하는 경우이다.
    cnt = 0 #큐가 몇 번 꺼내졌는지 확인할 변수, 이것이 노드의 개수보다 적다면 사이클이 발생한 것이다.
    result = [] #위상정렬의 결과를 담을 리스트
    q = deque()
    
    for i in range(1, n + 1):
        if indegree[i] == 0: #진입차수 0인 것을 큐에 담는다. 여기서 진입차수 0인 것이 없으면 impossible한 것.
            q.append(i)
    if not q:
        print("IMPOSSIBLE")
        continue
        
    while q:
        q_cnt = 0 #큐에 두 번 이상 들어가면 위상 정렬 경우가 여러개
        now = q.popleft() #현재 큐에서 원소 꺼내기
        cnt += 1
        result.append(now)
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
                q_cnt += 1
        if q_cnt > 1:
            break

    if q_cnt > 1: # 큐에 들어가는 원소가 2개 이상이면 경우가 여러개
        print('?')
    
    elif 0 < cnt < n: #큐가 n번 나오기 전에 끝나버리면 사이클이 발생한 것이다.
        print("IMPOSSIBLE")
    #그런게 아니라면 결과를 출력
    elif cnt == 0 or cnt == n:
        for i in result:
            print(i, end = ' ')