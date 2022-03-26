import sys
input = sys.stdin.readline
#파이썬은 보통 1초에 2000만번 연산 수행
#테스트케이스마다 입력을 받으므로 시간 초과를 피해주기 위해서 readline사용

#입력
t = int(input()) #테스트 케이스
for _ in range(t):
    n = int(input()) #지원자의 수 
    grade = [] #(서류심사 성적, 면접 성적)을 담을 곳
    for _ in range(n):
        grade.append(tuple(map(int, input().split())))

    #과정 
    #서류 심사를 기준으로 오름차순 정렬
    grade.sort() 
    temp = grade[0][1] #첫 번째(1등 심사) 면접 심사 등수를 temp에 담는다. 
    result = 1 #결과 출력용, 1등은 무조건 뽑히게 되어 있으므로 미리 카운트
    
    #서류 심사등수 기준으로 오름차순 정렬하였으므로 오른쪽으로 갈수록 서류 심사 자격 기준은 미달이 되는 것이다.
    #for문을 통해서 면접 심사 등수를 확인하면서 자격 조건 확인
    for i in range(n):
        if grade[i][1] < temp:
            result += 1
            temp = grade[i][1]

    #출력
    print(result)
