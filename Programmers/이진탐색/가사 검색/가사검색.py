from bisect import bisect_left, bisect_right

def count_by_bisect(arr, left, right):
    left_idx = bisect_left(arr, left)
    right_idx = bisect_right(arr, right)

    return right_idx - left_idx

#길이에 맞는 각 단어들을 모아두기 위해서 리스트를 2차원으로 생성
arr = [[] for _ in range(10001)]
#접두사의 경우 단어들을 전부 뒤집어서 접미사로 취급하여 대응 할 경우
arr_reversed = [[] for _ in range(10001)] 

def solution(words, queries):
    answer = []
    #해당 단어 길이의 인덱스에 단어를 삽입
    for word in words:
        arr[len(word)].append(word)
        arr_reversed[len(word)].append(word[::-1]) #이건 거꾸로 써서 삽입

    #이진 탐색을 수행하기 위해서 해당 인덱스에 있는 리스트를 오름차순으로 정렬
    for i in range(10001):
        arr[i].sort()
        arr_reversed[i].sort()

    #이진 탐색을 사용하여 queries에 들어있는 단어에 해당하는 개수를 셀 것이다.
    for i in queries:
        if i[0] != '?': #만약 접미라면
            cnt = count_by_bisect(arr[len(i)], i.replace('?', 'a'), i.replace('?', 'z'))
        else: #만약 접두라면
            cnt = count_by_bisect(arr_reversed[len(i)], i[::-1].replace('?', 'a'), i[::-1].replace('?', 'z'))
        answer.append(cnt)

    return answer