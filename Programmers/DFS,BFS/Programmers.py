from collections import deque

#올바른 괄호열인지 판단 하는 함수
def isCorrect(p):
    lst = [] #문자열의 문자를 하나하나 담을 lst
    for i in range(len(p)):
        if p[i] == '(': # 만약 열린 괄호이면 리스트에 넣는다.
            lst.append(p[i])
        elif p[i] == ')': # 만약 닫힌 괄호라면
            if len(lst) == 0: # 닫힌 괄호인데 lst가 빈 상태라면
                return False # 올바른 문자열이 아니다.
            lst.pop() # lst에 있는 열린 괄호를 하나 뽑는다.
    if len(lst): # lst에 열린 괄호가 남은 상태라면 올바른 문자열이 아니다.
        return False
    return True

def solution(p): #p는 균형잡힌 문자(열린 괄호와 닫힌 괄호가 같다.) 
    #종료 조건 -> 빈 문자열이라면 빈 문자열 반환
    if p == "" or isCorrect(p): # 또는 문자열이 처음부터 올바른 문자열이라면 그대로 반환
        return p
    length = len(p) # 문자열의 길이를 담는다.
    u = ""
    v = ""
    q = deque([p[0]]) # 문자열의 첫 번째 괄호를 큐에 넣는다.
    idx = 0    # 문자열의 첫 번째 괄호를 큐에 넣고 index는 0으로 초기화(p에서 인덱스 0을 가리킴)

    # 균형잡힌 문자열이 끝난 지점을 idx로 찾아나가는 작업
    while q:
        if q[-1] == p[idx + 1]: #만약 큐에 있는 괄호와 같은 괄호라면
            q.append(p[idx + 1]) #큐에 집어넣는다.
            idx += 1 # 현재 index를 다음 index로 업데이트
        else: # 큐에 있는 괄호와 다른 괄호라면
            q.pop() # 큐에 있는 괄호 하나를 제거
            idx += 1 # index 업데이트

    #인덱스를 기준으로 u와 v를 나누기    
    u = p[:idx + 1] # u는 더 이상 분리할 수 없는 균형잡힌 문자열을 담고 있다.
    v = p[idx + 1:] # 나머지 열은 v에 담기
    
    #만약 u가 '올바른 괄호 문자열'이라면 -> 즉 u의 시작 문자열이 열린 괄호라면(u가 균형잡힌 문자열이므로) v에 대하여 1단계부터 다시 수행   
    

    if u[0] == '(':
        return u + solution(v) 

    else: #그렇지 않다면(u가 올바른 괄호가 아니라면)
        answer = ""
        p = solution(v)        
        #u의 앞 뒤 문자 제거하고 괄호 뒤집기        
        u = list(u)
        u[0] = ""
        u[-1] = ""
        u = ''.join(u) #u를 다시 문자열로 변경         
        if u != "":
            for i in range(len(u)):
                if u[i] == '(':
                    u = list(u)
                    u[i] = ')'
                    u = ''.join(u)
                else:
                    u = list(u)
                    u[i] = '('
                    u = ''.join(u)
        
        answer += "(" + p + ")" + u
        return answer