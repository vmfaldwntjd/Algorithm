arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
#선택 정렬은 왼쪽 영역은 이미 정렬이 완료된 상태가 되는
#재미있는 특징이 있다. 그래서 비교할 때 자기보다 작은 숫자 만나면
#그 위치에서 멈추고 삽입한다.
#정렬이 거의 완료된 상태에서는 삽입 정렬이 매우 효율적이다.
for i in range(1, len(arr)):
    for j in range(i, 0, -1):
        if arr[j] < arr[j - 1]:
            arr[j], arr[j - 1] = arr[j - 1], arr[j]
        else:
            break
print(arr)