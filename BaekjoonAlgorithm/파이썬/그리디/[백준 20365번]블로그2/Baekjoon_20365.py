if __name__ == "__main__":
    #입력하기
    n = int(input())
    color = input() #색깔을 문자열로 입력 받기

    #과정
    blue = 0 #블루의 개수를 셀 변수
    red = 0 #레드의 개수를 셀 변수
    for i in range(len(color)):
        if i == 0: #첫 번째 인덱스라면
            if color[i] == 'B': #그것이 블루라면 블루를 카운트
                blue += 1
            else:
                red += 1 #그렇지 않다면 레드를 카운트
        else: #첫 번째 인덱스가 아니라면
            #각각의 연속된 색깔이 있담면 그것들을 하나로 취급하여 blue, red를 카운트해준다.
            #연속된 색깔이 아니라면 그냥 한 개 취급
            if color[i] == 'R' and color[i - 1] == 'B': #
                red += 1
            elif color[i] == 'B' and color[i - 1] == 'R':
                blue += 1

    print(min(red, blue) + 1) #이들 중 개수가 적은 것에서 1을 더해주면 된다.
    #제일 처음에 덧칠하는 경우도 생각을 해주어야 하기 때문에 1을 더해준 것이다.