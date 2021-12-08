#입력
n = int(input())
table = []
dp = [0] * (n + 1) # 전부 0으로 초기화
for i in range(n):
    table.append(list(map(int, input().split())))
mx = 0

#과정
#테이블을 거꾸로 스캔하면서
for i in range(n - 1, -1, -1):
    #만약 테이블 첫 번째 요소를 더했을 때 dp테이블의 범위를 벗어나지 않는다면
    if i + table[i][0] <= n:
        dp[i] = max(table[i][1] + dp[i + table[i][0]], mx)
        mx = dp[i]
    else:
        dp[i] = mx

#출력
print(mx)