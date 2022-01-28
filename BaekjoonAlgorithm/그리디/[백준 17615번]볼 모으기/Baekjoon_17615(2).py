#오른쪽 맨 끝의 연속적인 색깔을 뺀 나머지 색깔 중에서의 최솟값을 반환하는 메서드
def minMove(color):
    color_tmp = color.copy() #color의 정보를 바꾸지 않기 위해서 복사
    last = color_tmp.pop()
    for _ in range(n - 1):
        if last == color_tmp[-1]:
            color_tmp.pop()
    #남아있는 B와 R의 개수의 최솟값을 반환
    return min(color_tmp.count('R'), color_tmp.count('B'))
    
if __name__ == "__main__":
    #입력
    n = int(input())
    color = list(input())

    #출력
    #color를 그냥 확인한 경우와 뒤집어서 확인한 경우 중 최솟값을 출력
    print(min(minMove(color), minMove(color[::-1])))