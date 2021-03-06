문제링크: https://www.acmicpc.net/problem/10971
- - -
## 고찰 및 해결 과정
- 이 문제는 첫 번호를 지정했으면 모든 번호를 가능한 모든 경우의 방식으로 순회를 해서 다시 자기 자신으로 돌아와야 한다.  
- 예를 들어서 1, 2, 3, 4의 번호가 있고 1을 시작으로 지정한다면 가능한 순회의 경우는 다음과 같다.  
  ```TEXT
  1, 2, 3, 4
  1, 2, 4, 3
  1, 3, 2, 4
  1, 3, 4, 2
  1, 4, 2, 3
  1, 4, 3, 2
  ``` 
- 이렇게 시작점을 1로 가능한 모든 순회의 값들 중 최솟값이 정답이 된다.  
- 시작점을 2, 3, 4로 지정했을 때의 경우는 위의 시작점이 1인 경우의 수와 겹치므로 시작점을 1로 고정하고 모든 경우의 수를 살펴보면 된다.  
- 그렇게 되면 전체의 N개의 수열 중 한 자연수를 고정한 채 수열을 나열하는 경우의 수가 되므로 시간 복잡도는 O(N!)이 된다.  
- 왜냐하면 순열의 시간 복잡도는 O(NxN!)([백준의 모든 순열 해결 과정 참고](https://github.com/vmfaldwntjd/Algorithm/tree/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%EB%B8%8C%EB%A3%A8%ED%8A%B8%ED%8F%AC%EC%8A%A4/%5B%EB%B0%B1%EC%A4%80%2010974%EB%B2%88%5D%EB%AA%A8%EB%93%A0%20%EC%88%9C%EC%97%B4))인데 하나의 맨 앞 값을 고정했으므로  시간 복잡도는 O(N!)이다.  