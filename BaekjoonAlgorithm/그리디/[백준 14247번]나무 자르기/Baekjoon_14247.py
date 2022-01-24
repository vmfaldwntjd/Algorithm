#입력
n = int(input())
h = list(map(int, input().split()))
a = list(map(int, input().split()))

#과정
total = 0
tree = [] #(나무 키, 나무 자라는 시간)
for i in range(n):
    tree.append([h[i], a[i]])
tree.sort(key = lambda a : a[1]) #나무가 자라는 양을 기준으로 오름차순 정렬

for i in range(n):
    total += tree[i][0] + (tree[i][1] * i)

#출력
print(total)