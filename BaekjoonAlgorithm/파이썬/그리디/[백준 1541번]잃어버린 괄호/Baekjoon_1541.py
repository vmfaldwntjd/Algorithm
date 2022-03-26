if __name__ == "__main__":
    #입력
    s = input() #문자열 입력

    #과정
    #-기호를 기준으로 식 또는 값을 리스트에 분리 
    s_list = s.split('-') 

    #첫 번째 원소에 +가 포함된 식이 존재한다면 이들은 그대로 계산하고
    result = sum(map(int, s_list[0].split('+')))  #결과 출력용
    #나머지는 전부 빼주면 된다.
    for i in range(1, len(s_list)):
        result -= sum(map(int, s_list[i].split('+')))
    
    #결과 출력
    print(result)
