import heapq
#입력받기
n = int(input()) 
q = []
for _ in range(n):
    heapq.heappush(q, int(input())) #묶음이 낮은 카드 순으로 정렬하기

#과정
result = 0
while len(q) > 1: #큐의 길이가 1이 되면 더 이상 비교할 필요가 없으므로 반복문을 나온다.
    first = heapq.heappop(q) #카드 묶음 번호가 낮은 카드 두 개를 뽑는다.
    second = heapq.heappop(q)
    s = first + second # 이 두 묶음의 카드를 비교할 것이므로 서로 묶음 수를 더해준다.
    result += s # 이를 result에 축적시킨다.
    heapq.heappush(q, s) #묶음이 낮은 순으로 큐에 넣으면서 다시 정렬

#출력하기
print(result)