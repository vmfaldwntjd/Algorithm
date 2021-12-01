def is_correct(answer, n, x, y, a, b):
    #만약 삭제라면 일단 삭제하고 본다. 그리고나서 확인 후 규칙 안맞으면 되돌리기
    if b == 0:
        if [x, y, a] in answer:
            answer.remove([x, y, a])
        #제거하고 나서 보드의 상황을 파악하기, 규칙에 맞지 않은 좌표가 존재하는지 확인을 한다.
        #삭제인데 a가 기둥이라면 기둥 삭제시 규칙에 어긋나는 곳 없는지 확인 
        for x_tmp, y_tmp, a_tmp in answer:
            if a_tmp == 0: #기둥인 경우 바닥에 있거나 보의 한쪽 끝 부분 위에 있거나 삭제된 기둥 윗부분에는 기둥 없는지 확인
                if y_tmp == 0 or ([x_tmp, y_tmp, 1] in answer) or ([x_tmp - 1, y_tmp, 1] in answer) or ([x_tmp, y_tmp - 1, 0] in answer):
                    continue
                else:
                    answer.append([x, y, a])
                    break
            else: #a_tmp가 보인경우 -> 한 쪽 끝부분이 기둥 위에 있거나, 양쪽 끝부분이 다른 보와 동시에 연결되야 한다.
                if ([x_tmp, y_tmp - 1, 0] in answer) or ([x_tmp + 1, y_tmp - 1, 0] in answer) or (([x_tmp - 1, y_tmp, 1] in answer) and ([x_tmp + 1, y_tmp, 1] in answer)):
                    continue
                else:
                    answer.append([x, y, a])
                    break

    #삭제가 아니라면 추가하고 본다. 그리고나서 만족시키지 못하면 삭제를 하고 False를 반환해준다.
    else:
        answer.append([x, y, a])
        for x_tmp, y_tmp, a_tmp in answer:
            if a_tmp == 0: #기둥인 경우 바닥에 있거나 보의 한쪽 끝 부분 위에 있거나
                if y_tmp == 0 or ([x_tmp, y_tmp, 1] in answer) or ([x_tmp - 1, y_tmp, 1] in answer) or ([x_tmp, y_tmp - 1, 0] in answer):
                    continue
                else:
                    answer.remove([x, y, a])
                    break
            else: #a_tmp가 보인경우 -> 한 쪽 끝부분이 기둥 위에 있거나, 양쪽 끝부분이 다른 보와 동시에 연결되야 한다.
                if ([x_tmp, y_tmp - 1, 0] in answer) or ([x_tmp + 1, y_tmp - 1, 0] in answer) or (([x_tmp - 1, y_tmp, 1] in answer) and ([x_tmp + 1, y_tmp, 1] in answer)):
                    continue
                else:
                    answer.remove([x, y, a]) 
                    break
    
    
#벽면의 크기 nxn, 기둥과 보를 설치하거나 삭제하는 작업이 순서대로 담긴 2차원 배열 build_frame
def solution(n, build_frame):
    #먼저 보드판을 만들기(nxn 2차원 배열)
    answer = []
    
    #일단은 규칙대로 하나하나 결과 리스트에 담고 만약 규칙이 맞지 않는다면 다시 되돌리기
    for i in build_frame:
        x, y, a, b = i #(x, y), a에서 기둥은 0, 1은 보, b에서 0은 삭제, 1은 설치
        
        #만약 보드의 범위를 넘어가면 continue
        if x < 0 or y < 0 or x > n or y > n:
            continue
         
        is_correct(answer, n, x, y, a, b)
            

    return sorted(answer) #return 하는 배열은 가로 길이가 3인 2차원 배열, 각 구조물의 좌표를 담고 있어야 함.
