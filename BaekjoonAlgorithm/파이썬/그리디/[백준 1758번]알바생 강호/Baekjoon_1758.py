import sys
n = int(sys.stdin.readline())
res = 0
tip = []
for _ in range(n):
    tip.append(int(sys.stdin.readline()))
tip.sort(reverse = True)

for i in range(1, n+1):
    sm = tip[i-1] - (i - 1)
    if sm < 0:
        break
    else:
        res += sm
print(res)