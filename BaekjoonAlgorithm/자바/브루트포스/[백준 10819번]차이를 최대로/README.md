문제 링크: https://www.acmicpc.net/problem/10819
- - -
## 고찰 및 해결 과정
- N의 최댓값은 8이므로 모든 경우의 수들을 다 나열하면서 최댓값을 도출하는 방식으로 문제를 해결할 수 있다.  
- 모든 순열의 경우를 나열하는데 걸리는 시간 복잡도는 O(NxN!)이다. [모든 순열 문제 해결과정](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B8%8C%EB%A3%A8%ED%8A%B8%ED%8F%AC%EC%8A%A4/%5B%EB%B0%B1%EC%A4%80%2010974%EB%B2%88%5D%EB%AA%A8%EB%93%A0%20%EC%88%9C%EC%97%B4)참고  
- N의 최댓값 8을 적용하면 약 32만 번의 연산 횟수가 적용되므로 프로그램 실행 시간이 연산량 1억당 1초라고 가정했을 때 시간 초과가 걸리지 않는다.  
- 그래서 [다움 순열 문제의 해결 과정](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B8%8C%EB%A3%A8%ED%8A%B8%ED%8F%AC%EC%8A%A4/%5B%EB%B0%B1%EC%A4%80%2010972%EB%B2%88%5D%EB%8B%A4%EC%9D%8C%20%EC%88%9C%EC%97%B4)을 이용해서 문제를 해결하였다.  
