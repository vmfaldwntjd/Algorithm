import heapq

if __name__ == '__main__':
    #입력
    n = int(input())
    lesson_time = []
    for _ in range(n):
        lesson_time.append(list(map(int, input().split())))
    
    #과정
    lesson_time.sort()

    room = [] #방 리스트의 길이를 결과로 출력을 할 것이다.
    #첫 번째 수업의 끝나는 시간을 큐에 삽입
    heapq.heappush(room, lesson_time[0][1])
    
    for i in range(1, n):
        end_time = heapq.heappop(room)
        if lesson_time[i][0] < end_time:
            heapq.heappush(room, lesson_time[i][1])
            heapq.heappush(room, end_time)
        else:
            heapq.heappush(room, lesson_time[i][1])
    #출력
    print(len(room))