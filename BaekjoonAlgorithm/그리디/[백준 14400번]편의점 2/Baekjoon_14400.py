#입력
n = int(input())
x = []
y = []
for _ in range(n): #x좌표와 y좌표를 따로 분리하였다.
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

#과정
x.sort()
y.sort()
result = 0
idx = n // 2
for i in range(n):
    result += abs(x[idx] - x[i]) + abs(y[idx] - y[i])

#출력
print(result)