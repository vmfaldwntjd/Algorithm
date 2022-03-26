if __name__ == '__main__':
    #입력 
    n = int(input())
    k = int(input())

    #센서의 중복을 방지하기 위해서 집합 잘료형을 사용
    sensor = set(map(int, input().split()))
    
    #과정
    diff = [] #인접한 센서의 거리를 저장하기 위한 리스트 
    sensor = list(sensor) #인덱싱 및 정렬을 위해서 리스트로 변경
    length = len(sensor) # 현재 센서의 길이를 받는다.
    sensor.sort() # 센서의 위치를 오름차순으로 변경
    for i in range(1, length): #인접한 센서의 거리를 diff에 담는다.
        diff.append(sensor[i] - sensor[i - 1])
    diff.sort() #오름차순 정렬
    
    #출력
    print(sum(diff[0:length - k]))
