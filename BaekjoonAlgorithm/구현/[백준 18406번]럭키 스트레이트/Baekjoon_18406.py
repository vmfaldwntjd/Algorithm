import sys

#입력하기
n = sys.stdin.readline().rstrip()

#과정
s1 = n[:(len(n) - 1)//2 + 1]
s2 = n[(len(n) - 1)//2 + 1:]
first = 0
last = 0
for i in s1:
    first += int(i)

for i in s2:
    last += int(i)
    
#출력하기
if first == last:
    print('LUCKY')
else:
    print("READY")