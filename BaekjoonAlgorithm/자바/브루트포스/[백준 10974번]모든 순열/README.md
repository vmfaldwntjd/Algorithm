문제 링크: https://www.acmicpc.net/problem/10974
- - -
## 고찰 및 해결 과정 
- 이 문제는 자연수 n이 주어졌을 때 나올 수 있는 수열의 경우를 사전순으로 출력하는 문제이다.  
- 그래서 나는 [백준 문제 다음 순열 방식](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B8%8C%EB%A3%A8%ED%8A%B8%ED%8F%AC%EC%8A%A4/%5B%EB%B0%B1%EC%A4%80%2010972%EB%B2%88%5D%EB%8B%A4%EC%9D%8C%20%EC%88%9C%EC%97%B4)을 이용해서 나올 수 있는 모든 수열의 경우를 출력하였다.  
- 자연수 n이 주어졌을 때 주어질 수 있는 모든 수열의 경우의 수는 n!이고, '다음 순열'방식을 이용했을 때의 시간 복잡도는 O(N)이었으므로 총 시간복잡도는 O(NxN!)임을 알 수가 있다.  