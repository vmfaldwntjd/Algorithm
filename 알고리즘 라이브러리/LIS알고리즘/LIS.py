# LIS 알고리즘 
n = 6
arr = [10, 20, 10, 30, 20, 50]
dp = [1] * n

#LIS 알고리즘 수행
for i in range(1, n):
    for j in range(0, i):
        if arr[j] < arr[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(dp[-1]) # 즉 가장 긴 수열은 [10, 20, 30, 50]으로 
# 총 4개를 담고 있다.