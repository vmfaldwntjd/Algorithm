if __name__ == '__main__':
    #입력
    n, k = map(int, input().split())
    heights = list(map(int, input().split()))

    #과정
    result = 0
    diff = [] #인접한 학생의 키 차이를 나타내기 위한 리스트
    for i in range(1, n):
        diff.append(heights[i] - heights[i - 1])
    
    diff.sort() #오름차순 정렬

    #출력
    print(sum(diff[0:n - k]))

    



    