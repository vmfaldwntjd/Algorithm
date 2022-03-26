#입력
t = int(input())
for _ in range(t):
    #사탕 개수, 상자 개수
    j, n = map(int, input().split())
    boxes = []
    for _ in range(n):
        r, c = map(int, input().split())
        boxes.append(r*c)

    #과정
    boxes.sort(reverse = True)
    result = 0
    for i in boxes:
        if j > 0:
            j -= i
            result += 1
    print(result)
        