def solution(N, stages): #N은 스테이지 개수
    answer = []
    len_of_stage = len(stages) # 스테이지 길이를 잰다.

    #스테이지 번호를 1부터 N까지 증가시키며
    for i in range(1, N + 1):
        # 해당 스테이지에 머물며 있는 사람의 수 계산
        num_of_users = stages.count(i)
    
        #실패율 계산
        if len_of_stage == 0:
            fail = 0
        else:
            fail = num_of_users / len_of_stage 
        
        # 리스트에 (스테이지 번호, 실패율) 원소 삽입
        answer.append((i, fail))
        len_of_stage -= num_of_users #유저 수 만큼 빼주기
    
    #실패율을 기준으로 각 스테이지를 내림차순 정렬
    answer = sorted(answer, key = lambda t: t[1], reverse = True)

    #정렬된 스테이지 번호만 담아서 출력하기
    answer = [i[0] for i in answer]
    return answer