#입력 
t = int(input())
for _ in range(t):
    #a를 b로 만들어야 하는데 드는 최소 횟수
    a, b = input().split()

    #과정
    total_diff = 0
    zero_count = 0
    one_count = 0

    for i in range(len(a)):
        if a[i] != b[i]:
            if a[i] == '0':
                zero_count += 1
            else:
                one_count += 1
            total_diff += 1 #두 비트의 자리에서 숫자가 다른 부분을 다 세어준다.

    #출력
    if zero_count > one_count: #a비트에서 서로 비트가 다른 곳들 중 '0'이 더 많다면
        print(total_diff - one_count) #a비트에서 '1'은 서로 뒤바꾸면 되므로 총 횟수에서 '1'이 세어진 횟수를 뺀다.
    elif zero_count < one_count:
        print(total_diff - zero_count)
    else: #'0'의 개수와 '1'의 개수가 같다면 서로 뒤바꾸면 된다.
        print(total_diff // 2)
