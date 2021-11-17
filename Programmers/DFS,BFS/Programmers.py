from collections import deque

#올바른 괄호열인지 판단 하는 함수
def isCorrect(p):
    lst = []
    for i in range(len(p)):
        if p[i] == '(':
            lst.append(p[i])
        elif p[i] == ')':
            if len(lst) == 0:
                return False
            lst.pop()
    if len(lst):
        return False
    return True

def solution(p): #p는 균형잡힌 문자(열린 괄호와 닫힌 괄호가 같다.) 
    #종료 조건 -> 빈 문자열이라면 빈 문자열 반환
    if p == "" or isCorrect(p):
        return p
    length = len(p)
    u = ""
    v = ""
    q = deque([p[0]])
    idx = 0    
    while q:
        if q[-1] == p[idx + 1]: #만약 큐에 있는 괄호와 같은 괄호라면
            q.append(p[idx + 1])
            idx += 1
        else:
            q.pop()
            idx += 1

    #인덱스를 기준으로 u와 v를 나누기    
    u = p[:idx + 1]
    v = p[idx + 1:]
    
    #만약 u가 '올바른 괄호 문자열'이라면 -> 즉 u의 시작 문자열이 열린 괄호라면 v에 대하여 1단계부터 다시 수행    
    if u[0] == '(':
        return u + solution(v) 

    else: #그렇지 않다면(u가 올바른 괄호가 아니라면)
        answer = ""
        p = solution(v)        
        #u의 앞 뒤 문자 제거하고 괄호 뒤집기        
        u = list(u)
        u[0] = ""
        u[-1] = ""
        u = ''.join(u)
        
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