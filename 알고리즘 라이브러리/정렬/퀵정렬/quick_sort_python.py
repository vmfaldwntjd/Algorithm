arr = [5, 7, 9 ,0, 3, 1, 6, 2, 4, 8]
def quick_sort(arr):
    #리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(arr) <= 1:
        return arr
    pivot = arr[0] #피벗은 첫 번째 원소(이번에는 인덱스가 아니다.)
    tail = arr[1:] #피벗을 제외한 리스트

    #분할된 왼쪽 부분(이번엔 피벗보다 작은 값을 찾아나간다!)
    left_side = [x for x in tail if x <= pivot] 
    #분할된 오른쪽 부분(이번엔 피벗보다 큰 값을 찾아나간다!)
    right_side = [x for x in tail if x > pivot] 

    #분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 
    #전체 리스트를 반환
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)
print(quick_sort(arr))