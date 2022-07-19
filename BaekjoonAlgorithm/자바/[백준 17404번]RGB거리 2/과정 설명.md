문제 링크: https://www.acmicpc.net/problem/17404
- - -
> 고찰 및 해결 과정  
- 첫 번째와 n 번째가 서로 같은 색이 되면 안 된다는 조건 때문에 꽤나 고민을 엄청 많이 했었다.  
- 처음에는 다이나믹 프로그래밍 수행을 위해서 dp 테이블을 3차원으로 정해서 n 번째와 첫 번째의 위치를 기준으로 해결하려고 하였으나 여러 반례가 적용되어서 3차원 방식의 해결은 포기했다.  
- 결국 [백준 RGB 거리](https://github.com/vmfaldwntjd/Algorithm/blob/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%5B%EB%B0%B1%EC%A4%80%201149%EB%B2%88%5DRGB%EA%B1%B0%EB%A6%AC/Main.java)문제에서 풀은 코드에 부가 가능을 추가하기로 하였다.  
- 첫 번째의 색깔이 빨강, 초록, 파랑일 때의 경우로 각각 나누어서 각각 dp테이블을 수행하고 n 번째의 색깔이 첫 번째와 다른 색깔일 때의 경우의 최솟값을 구하였다.  
