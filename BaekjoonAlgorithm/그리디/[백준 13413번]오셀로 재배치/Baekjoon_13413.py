#입력
t = int(input())
for _ in range(t):
    n = int(input())
    start = input() #말의 초기 상태 
    target = input() #목표 상태

    #과정
    total_diff = [] #배치된 말이 서로 다를 경우 해당 위치의 start 말을 저장할 것이다.
    for i in range(n):
        if start[i] != target[i]:
            total_diff.append(start[i])
    
    #출력
    print(max(total_diff.count('W'), total_diff.count('B'))) #적은 말은 서로 뒤바뀔 것이므로 결국은 많은 말을 선택하는 것과 같다.