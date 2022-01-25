#입력
n, l = map(int, input().split())
tree = sorted(list(map(int, input().split())))

#과정
start = 0 #시작 지점을 0으로 초기화 
result = 0 #결과 출력용
for i in tree:
    if start <= i - 0.5: #만약 현재 지점까지의 길이 범위 내가 아니라면
        start = i - 0.5 + l #테이프를 카운트하고 다음 지점을 찾는다.
        result += 1

#출력
print(result)


