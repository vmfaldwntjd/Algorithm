#입력
n = int(input())
lst = []
for _ in range(n):
    name, k_score, m_score, e_score = input().split()
    lst.append((name, int(k_score), int(m_score), int(e_score)))

#과정
lst.sort(key = lambda score: (-score[1], score[2], -score[3], score[0]))

#출력
for i in range(n):
    print(lst[i][0])