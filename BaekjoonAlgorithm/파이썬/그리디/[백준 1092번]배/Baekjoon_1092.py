from collections import deque
import sys
input = sys.stdin.readline

if __name__ == '__main__':
    #입력
    n = int(input()) #크레인의 수
    #각 크레인의 무게제한을 입력
    crane = sorted(list(map(int, input().split())), reverse = True)
    m = int(input()) #박스의 수

    #박스의 무게
    box = sorted(list(map(int, input().split())), reverse = True)
    
    #과정
    result = 0
    
    if crane[0] < box[0]: #box의 최댓값이 crane의 최댓값보다 크다면 이는 다 옮길 수 없다는 것을 의미
        #출력
        print(-1)
    else:
        box = deque(box) 
        box_tmp = []
        crane_tmp = []

        #이중 반복문을 쓰면 시간 초과가 일어나는 듯
        while box or box_tmp: # 종료 조건은 box나 box_tmp가 다 비어질 때까지다.
            if len(crane_tmp) == n: #만약 crane_tmp가 크레인의 개수와 같아졌다면 크레인을 다 살펴본 것이다.
                result += 1 #카운트
                crane_tmp.clear() #크레인 인덱스를 다시 초기화 
                box.extendleft(reversed(box_tmp)) #box_tmp에 있던 것들은 최댓값 순으로 다시 box로 옮긴다.
                box_tmp.clear() 
            
            else:
                if not box and box_tmp: #box가 다 비어버린 상태이고 box_tmp에 값들이 남아있다면 
                    result += 1 #카운트
                    crane_tmp.clear() #다시 크레인 인덱스를 초기화
                    box.extendleft(reversed(box_tmp))
                    box_tmp.clear()

            #만약 크레인의 현재 인덱스가 박스의 크기보다 크거나 같다면
            if crane[len(crane_tmp)] >= box[0]:
                box.popleft() #박스 안의 요소 제거
                crane_tmp.append(crane[len(crane_tmp)]) #크레인의 인덱싱을 위해서 crane_tmp를 이용하였다.
            
            else: #그렇지 않다면 박스 안의 요소를 box_tmp로 옮기고 다음 요소를 확인해야한다.
                box_tmp.append(box.popleft())

           
        print(result + 1)
