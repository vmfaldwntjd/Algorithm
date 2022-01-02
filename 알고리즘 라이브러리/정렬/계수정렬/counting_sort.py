#모든 원소의 값이 0보다 크거나 같다고 가정
arr = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
cnt = [0] * (max(arr) + 1) # 배열의 크기에서 1을 더한 만큼의 새로운 리스트 생성

for i in range(len(arr)):
    cnt[arr[i]] += 1 #각 데이터에 해당하는 인덱스의 값 증가

for i in range(len(cnt)): #리스트에 기록된 정렬 정보 확인
    for j in range(cnt[i]): #해당 인덱스에 적힌 횟수만큼
        print(i, end = ' ') # 출력