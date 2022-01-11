import heapq

def solution(food_times, k):
    #food_times에 있는 음식의 총 시간이 k보다 작거나 같을 때는 -1
    if sum(food_times) <= k:
        return -1

    q = [] #우선 순위 큐를 사용하여 음식 시간이 최소인 것을 우선으로 취급
    n = len(food_times)
    for i in range(n):
        #튜플 형식으로 (음식 시간, 음식 번호)를 우선순위 큐에 삽입
        heapq.heappush(q, (food_times[i], i + 1))
    total = 0 #총 시간을 담을 변수
    prev = 0
    #종료 조건은 현재 큐에 있는 음식 시간을 통한 계산된 총 시간이
    #k를 넘어설 때까지다.
    while (total + (q[0][0] - prev) * n) <= k:
        current = heapq.heappop(q)[0] #음식 시간을 뽑아낸다.
        total += (current - prev) * n #현재 음식 시간에 음식 개수만큼 곱해주면 이 시간은 최소인 음식 시간이 0이 될 때까지 걸리는 시간이다.
        n -= 1 #음식 하나가 없어졌으므로 음식 개수는 1감소
        prev = current #현재 음식 시간이 사라지는 동안 다른 음식
        #시간에도 prev만큼 영향을 미쳤을 것이다.

    #반복문을 나왔으면 남아 있는 큐에서 계산 시작
    answer = sorted(q, key = lambda a : a[1]) #음식 번호를 기준으로 다시 정렬
    return answer[(k - total) % n][1]
