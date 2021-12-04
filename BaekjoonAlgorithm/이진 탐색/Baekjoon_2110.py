#입력
n, c = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(int(input()))

#과정
#[1, 2, 8, 4, 9]가 있을 때 인접한 영역을 기준으로 이진탐색을 수행
# 먼저 최소 gap과 최대 gap을 지정한 다음 그 중간값을 기준으로 공유기를 
#설치할 수 있는 개수를 구한 다음 c보다 크거나 같은 경우
#즉, c보다 더 많은 공유기 설치가 가능한 경우 gap을 더 늘려야 하므로 시작점 
#즉, gap의 최소를 업데이트
# 반면 공유기를 c보다 더 적게 설치할 수 밖에 없는 경우 영역을 줄여야하므로 
#gap의 최대를 업데이트
#그러다 최소 gap과 최대 gap이 엇갈리면 반복을 종료한다.
arr.sort() #이진 탐색을 위해서 오름차순 정렬
min_gap = 1 # gap의 최솟값을 1로 설정
max_gap = arr[-1] - arr[0] # 최대 gap 설정
result = 0 # 인접한 두 공유기 거리 최댓값을 저장할 것이다.
#이진 탐색을 수행
while min_gap <= max_gap:
    # 최대 gap과 최소 gap의 중간값을 설정
    #공유기를 설치할 수 있는 간격의 최솟값 gap이다.
    gap = (min_gap + max_gap) // 2
    current = arr[0] # 이 시작점을 기준으로 gap만큼의 간격으로 공유기를 설치
    cnt = 1 # current에 공유기를 설치했으므로 공유기 설채 개수 하나 카운트
    
    # 공유기를 설치하며 개수를 세는 작업
    for i in range(1, n):
        #만약 현재 원소값이 current 값에 gap만큼 더한 값보다
        #크거나 같다면 공유기를 설치 가능하다.
        if arr[i] >= current + gap:
            current = arr[i]
            cnt += 1
    #만약 이 공유기 설치 개수가 설치 가능한 공유기 개수 c보다 크거나 같다면 
		#min_gap을 업데이트
    if cnt >= c:
        min_gap = gap + 1
        result = gap
    else: #그렇지 않다면 max_gap을 업데이트
        max_gap = gap - 1

#출력
print(result)