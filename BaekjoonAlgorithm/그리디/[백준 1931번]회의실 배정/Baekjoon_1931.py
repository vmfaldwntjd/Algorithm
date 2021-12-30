if __name__ == "__main__":
    # 입력
    n = int(input())
    meeting = [] #각 회의의 시작 시간과 끝시간을 튜플 형식으로 담을 것이다.
    result = 0
    for _ in range(n):
        a, b = map(int, input().split())
        meeting.append((a, b)) # 회의의 정보를 담은 리스트

    #과정
    meeting = sorted(meeting, key = lambda a : (a[1], a[0]))
    end_value = 0
    for start_meet, end_meet in meeting:
        if start_meet >= end_value:
            result += 1
            end_value = end_meet
    
    #출력
    print(result)
