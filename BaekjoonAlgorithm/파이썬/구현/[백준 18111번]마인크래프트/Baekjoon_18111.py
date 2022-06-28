import sys

if __name__ == "__main__":
    n, m, b = map(int, sys.stdin.readline().split())
    board = [list(map(int, sys.stdin.readline().split())) for i in range(n)]
        
    ans = sys.maxsize
    for i in range(257):
        add_block = 0
        sub_block = 0
        
        for j in range(n):
            for k in range(m):
                if board[j][k] > i:
                    sub_block += board[j][k] - i
                else:
                    add_block += i - board[j][k]
        if sub_block + b >= add_block:
            t = sub_block * 2 + add_block
            if ans >= t:
                ans = t
                height = i
    print(ans, height)